(function (){

    var topTap = (function (){

        // var ajaxCallback = AjaxProm({url : './top/'+id, type : "GET"});
        // /ajaxCallback.then(function(data){

        // });

        var TAP_TYPE = {al : '전체', exp : '이용예정', fin : "이용완료", cancel : "취소·환불"};
        var soruce = $("#article-template").html();
        var template = Handlebars.compile(soruce);

        $('.summary_board li').on('click',function(){
            $('.summary_board li').find('.link_summary_board').removeClass('on');
            $(this).find('.link_summary_board').addClass('on');

            var type = $(this).find('.tit').text();

            if (type === TAP_TYPE.al){
                console.log(type)
            } else if ( type === TAP_TYPE.exp){
                console.log(type)
            } else if ( type === TAP_TYPE.fin){
                console.log(type)
            } else if ( type === TAP_TYPE.cancle){
                console.log(type)
            }
        })

        function changeTabNum(option){
            $('.summary_board .figure').eq(0).text(option.all);
            $('.summary_board .figure').eq(1).text(option.expe);
            $('.summary_board .figure').eq(2).text(option.fin);
            $('.summary_board .figure').eq(3).text(option.cancel);
        }

        changeTabNum({all : 1, expe: 3, fin :5, cancel : 7});

        function removeCard(type)
        {
            $('.card').eq(0).find('.card_item').remove();
            $('.card').eq(0).remove();
        }

        function allArticle(root){
            var context = {};
            var html = template(context);

            $(root).show();

            var $element_ul = parent.$(root);

            $(html).appendTo($element_ul);
        }


    })();

})();
