/**
 * 
 */

 
function passwdCheck(){
   if(idelForm.i_passwd.value == ""){
      alert("비밀번호를 입력하세요");
      idelForm.i_passwd.focus();
      return false;
   }   
};

function inUpdate(){

      var iwriter = $('#iwriter').val();
      var isubject = $('#isubject').val();
      var icontent = $('#icontent').val();
      var ipasswd = $('#ipasswd').val();
      var blank_pattern = /^\s+|\s+$/g;
      
      if( iwriter.replace( blank_pattern, '' ) == ""){
          alert('작성자에 공백만 입력되었습니다 ');
          return false;
      }
      
      if( isubject.replace( blank_pattern, '' ) == ""){
          alert('제목에 공백만 입력되었습니다 ');
          return false;
      }
      
      if(isubject.length > 10){
         alert('제목은 10자 이내로 적어주세요.')
         return false;
      }
      
      if( icontent.replace( blank_pattern, '' ) == "" ){
          alert('내용에 공백만 입력되었습니다 ');
          return false;
      }
      
      if(icontent.length > 666){
         alert('내용이 너무 깁니다.')
         return false;
      }
       
      
      if( ipasswd.replace( blank_pattern, '' ) == ""){
          alert('비밀번호에는 공백을 넣을 수 없습니다.');
          return false;
      }

   };

function inwriteSave(){
   
      var iwriter = $('#iwriter').val();
      var isubject = $('#isubject').val();
      var icontent = $('#icontent').val();
      var ipasswd = $('#ipasswd').val();
      var blank_pattern = /^\s+|\s+$/g;
      
      if( iwriter.replace( blank_pattern, '' ) == ""){
          alert('작성자에 공백만 입력되었습니다 ');
          return false;
      }
      
      if( isubject.replace( blank_pattern, '' ) == ""){
          alert('제목에 공백만 입력되었습니다 ');
          return false;
      }
      
      if(isubject.length > 10){
         alert('제목이 너무 깁니다.')
         return false;
      }
      
      if( icontent.replace( blank_pattern, '' ) == "" ){
          alert('내용에 공백만 입력되었습니다 ');
          return false;
      }
      
      if(icontent.length > 666){
         alert('내용이 너무 깁니다.')
         return false;
      }
       
      
      if( ipasswd.replace( blank_pattern, '' ) == ""){
          alert('비밀번호에는 공백을 넣을 수 없습니다.');
          return false;
      }

};   
