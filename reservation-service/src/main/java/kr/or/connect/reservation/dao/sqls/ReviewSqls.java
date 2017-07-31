package kr.or.connect.reservation.dao.sqls;

public class ReviewSqls {

    public final static String SELECT_REVIEW_COMMENT_INFO = "SELECT comment_info.id , COUNT(comment_info.id) AS img_count ,nickname, product_id, user_id, MIN(file_id) AS file_id, score, comment, comment_info.create_date, comment_info.modify_date "
            + "FROM users "
            + "INNER JOIN "
            + "(SELECT DISTINCT reservation_user_comment.id, product_id, user_id, file_id, score, comment, create_date, modify_date "
            + "FROM reservation_user_comment "
            + "LEFT OUTER JOIN "
            + "reservation_user_comment_image ON reservation_user_comment.id = reservation_user_comment_id "
            + "WHERE product_id = :id)comment_info ON users.id = comment_info.user_id GROUP BY comment_info.id LIMIT 0 ,10";

    public final static String SELECT_REVIEWCOMMENT_IMAGE = "SELECT FILE_ID.id AS commentId , file.id as fileId "
            + "FROM file "
            + "INNER JOIN "
            + "(SELECT reservation_user_comment.id, file_id "
            + "FROM reservation_user_comment "
            + "INNER JOIN "
            + "reservation_user_comment_image ON reservation_user_comment.id = reservation_user_comment_id "
            + "WHERE reservation_user_comment.id = :id)file_id ON file.id = file_id.file_id";
}
