    <script>
        function getCookie(name)
        {
            var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)"); 
            if(arr=document.cookie.match(reg)){
                return unescape(arr[2]);
            }
            else{
                return null;
            }
        }
        function auth() {
            if(getCookie('token')==null){
                window.location.replace("http://localhost:9001/common/login.html");
            }
        }
        auth();
    </script>