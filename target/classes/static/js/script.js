function successfullyLogout(){
alert("Zostałaś/eś pomyślnie wylogowany");
}
function successfullyUmowione(){
alert("Twoje spotkanie zostało umówione");
}

function successfullySend(){
alert("Przypomnienie zostało wysłane na maila ");
}

function successfullyReserved(){
alert("Rezerwacja została przyjęta :)");
}

function successfullyMore(){
alert("Widząc twoje zainteresowanie tym autem, wysłaliśmy na twojego maila dodatkowe informacje.W razie pytań zachęcamy do dzwonienia na infolinię a nasi pracownicy na pewno pomogą :)");
}

const picker = document.getElementById('date');
picker.addEventListener('input', function(e){
  var day = new Date(this.value).getUTCDay();
  if([6,0].includes(day)){
    e.preventDefault();
    this.value = '';
    alert('W weekendy nie umawiamy spotkań :)');
  }
});

function validateLetters(evt) {
  var theEvent = evt || window.event;


  if (theEvent.type === 'paste') {
      key = event.clipboardData.getData('text/plain');
  } else {

      var key = theEvent.keyCode || theEvent.which;
      key = String.fromCharCode(key);
  }
  var regex = /[a-z]|\./;
  if( !regex.test(key) ) {
    theEvent.returnValue = false;
    if(theEvent.preventDefault) theEvent.preventDefault();
  }
}
function validateNumbers(evt) {
  var theEvent = evt || window.event;


  if (theEvent.type === 'paste') {
      key = event.clipboardData.getData('text/plain');
  } else {

      var key = theEvent.keyCode || theEvent.which;
      key = String.fromCharCode(key);
  }
  var regex = /[0-9]|\./;
  if( !regex.test(key) ) {
    theEvent.returnValue = false;
    if(theEvent.preventDefault) theEvent.preventDefault();
  }
}
