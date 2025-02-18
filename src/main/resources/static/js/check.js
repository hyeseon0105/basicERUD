$(document).ready(function(){
    $("form").on("submit", function(){
        if($("#name").val().length == 0){
            event.preventDefault()
            alert("이름을 입력하세요")
            $("#name").focus()
            return
        }
        if($("#age").val().length == 0){
            event.preventDefault()
            alert("나이를 입력하세요")
            $("#age").focus()
            return
        }
    })
})