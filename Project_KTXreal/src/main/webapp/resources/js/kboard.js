/**
 * 
 */

 
function passwdCheck(){
   if(kdelForm.k_passwd.value == ""){
      alert("비밀번호를 입력하세요");
      kdelForm.k_passwd.focus();
      return false;
   }   
};

function kupdate(){
      
      var kwriter = $('#kwriter').val();
      var ksubject = $('#ksubject').val();
      var kcontent = $('#ct').val();
      var kpasswd = $('#kpasswd').val();
      var blank_pattern = /^\s+|\s+$/g;
      
      if( kwriter.replace( blank_pattern, '' ) == ""){
          alert('작성자에 공백만 입력되었습니다 ');
          return false;
      }
      
      if( ksubject.replace( blank_pattern, '' ) == ""){
          alert('제목에 공백만 입력되었습니다 ');
          return false;
      }
      
      if(ksubject.length > 10){
         alert('제목은 10자 이내로 적어주세요.')
         return false;
      }
      
      if( kcontent.replace( blank_pattern, '' ) == "" ){
          alert('내용에 공백만 입력되었습니다 ');
          return false;
      }
      
      if(kcontent.length > 666){
         alert('내용이 너무 깁니다.')
         return false;
      }
       
      
      if( kpasswd.replace( blank_pattern, '' ) == ""){
          alert('비밀번호는 공백을 넣을 수 없습니다.');
          return false;
      }
   
   };

function kwriteSave(){
      
      var ksubject = $('#ksubject').val();
      var kcontent = $('#kcontent').val();
      var kpasswd = $('#kpasswd').val();
      var blank_pattern = /^\s+|\s+$/g;
      
      if(ksubject.replace( blank_pattern, '' ) == ""){
          alert('제목에 공백만 입력되었습니다 ');
          return false;
      }
      if(ksubject.length > 10){
         alert('제목이 너무 깁니다.')
         return false;
      }
      if(kcontent.replace( blank_pattern, '' ) == "" ){
          alert('내용에 공백만 입력되었습니다 ');
          return false;
      }
      if(kcontent.length > 666){
         alert('내용이 너무 깁니다.')
         return false;
      }
      
      if(kpasswd.replace( blank_pattern, '' ) == "" ){
          alert('비밀번호는 공백을 넣을 수 없습니다.');
          return false;
      }
      
};   

	
	