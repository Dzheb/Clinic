$(document).ready(function(){
  // кнопка отправки даты
  $("#show_docs").click(function(){

    $.ajax({
      url: '/showdocs',
      method: 'get',
      dataType: 'html',
      success: function(data){
        $("#footer").html(data);
      },
      error: function (e) {
        alert("Ашипка!!!");
      }
  });
   
  });
  // кнопка отправки даты
  $("#meet_date").click(function(){

    $.ajax({
      url: '/doctor',
      method: 'post',
      dataType: 'text',
      data: {text:'Текст'},
      success: function(data){
        $("#footer").html(data);
      },
      error: function (e) {
        alert("Ашипка!!!");
      }
  });
   
  });
  // кнопка отправки даты
  $("#add_patient").click(function(){

    $.ajax({
      url: '/addpatient',
      method: 'post',
      dataType: 'html',
      success: function(data){
        $("#footer").html(data);
      },
      error: function (e) {
        alert("Ашипка!!!");
      }
  });
   
  });
  // кнопка сохранить
  $("#but_save").click(function(){
    $("#alert").show();
    $("#alert").fadeOut(2000);
  });
  $(".edit").click(function() {
    alert( window.location.href.split('&')[0]);
    });  
});
// шифрование sha256
function sha256(mes) {
return CryptoJS.SHA256(mes, "");
}
// +30 мин. ввода времени
function time30Plus() {
  document.getElementById("myTime").stepUp(30);
}
// -30 мин.ввода времени
function time30Minus() {
  document.getElementById("myTime").stepDown(30);
}
// запись изменений Описания компании
function edit_doctor(id) {
  alert(id);
  // $.ajax({
  //   type: 'POST',
  //   url: '/kernel/scripts/update_company.php',
  //   dataType: 'json',
  //   data: {
  //     //id на случай если будет другая компания по id
  //     id: window.location.href.split('&idc=')[1],
  //     act: 'save_accounts',
  //     story: sdata,
  //   },
  // success: function (data) {
  //     // spawn_alert('success', 'Информация сохранена');
  //   },
  // });
}