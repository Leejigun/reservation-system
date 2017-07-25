package kr.or.seongjin.reservation.service.impl;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import kr.or.seongjin.reservation.dao.UserDao;
import kr.or.seongjin.reservation.dto.NaverLoginToken;
import kr.or.seongjin.reservation.dto.NaverToken;
import kr.or.seongjin.reservation.dto.User;
import kr.or.seongjin.reservation.service.LoginService;

@Service
public class NaverLoginService implements LoginService {

	private static final String REDIRECT_URI = "http://localhost:8080/login/callback";
	private static final String CERTIFICATE_URI = "https://nid.naver.com/oauth2.0/authorize?";
	private static final String ClIENT_ID = "TR3o9GBFUdOU1HyyRoxY";
	private static final String ClIENT_SECRET = "aOJJjemMyU";
	private static final String TOKEN_URI = "https://nid.naver.com/oauth2.0/token?";
	private static final String USER_INFO_URI = "https://openapi.naver.com/v1/nid/me";

	
	private UserDao userDao;

	private String getState() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}

	@Autowired
	public NaverLoginService(UserDao userDao) throws UnsupportedEncodingException {
		this.userDao = userDao;
	}

	@Override
	public String requestCertification(HttpSession session,String originPath) throws UnsupportedEncodingException {
		System.out.println(originPath);
		session.setAttribute("state", getState());
		String apiUrl = CERTIFICATE_URI + "client_id=" + ClIENT_ID + "&response_type=code" + "&redirect_uri="
				+ URLEncoder.encode(REDIRECT_URI+"?originPath="+originPath, "UTF-8") + "&state=" + session.getAttribute("state");
		return apiUrl;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public User requestUserInfo(String code, String state) {
		RestTemplate restTemplate = new RestTemplate();
		NaverToken naverToken = restTemplate
				.getForObject(
						TOKEN_URI + "client_id=" + ClIENT_ID + "&client_secret=" + ClIENT_SECRET
								+ "&grant_type=authorization_code" + "&state=" + state + "&code=" + code,
						NaverToken.class);

		HttpHeaders header = new HttpHeaders();
		header.set("Authorization", naverToken.getToken_type() + " " + naverToken.getAccess_token());
		ResponseEntity<NaverLoginToken> loginToken;
		loginToken = restTemplate.exchange(USER_INFO_URI, HttpMethod.GET, new HttpEntity(header),
				NaverLoginToken.class);

		return loginToken.getBody().getResponse();
	}

	@Override
	public User logIn(User user) {
		
		User alreadyUser = selectUser(user.getId());
		if(alreadyUser.getId()==null) {
			Integer newUserId = userDao.insert(user);
			return userDao.selectUser(newUserId);
		}
		else {
			return alreadyUser;
		}
	}

	private User selectUser(Integer id) {
		return userDao.selectUser(id);
	}

}
