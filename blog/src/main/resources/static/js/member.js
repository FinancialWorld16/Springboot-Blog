let index={
    init: function(){
        $("#btn-save").on("click", ()=>{ //this를 바인딩하기 위해서
            this.save();
        });
    },

    save: function(){
        //alert('user의 save함수 호출됨');
        let data={
            memberName: $("#memberName").val(),
            password: $("#password").val(),
            email: $("#email").val()
        };

    //console.log(data);

        $.ajax({
            type:"POST",
            url: "/api/member",
            data: JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done(function(resp){
            alert("회원가입이 완료되었습니다.");
            location.href="/";
        }).fail(function(error){
            alert(JSON.stringify(error));
        }); //ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청
    }
}

index.init();