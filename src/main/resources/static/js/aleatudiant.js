/**
 * 
 */

var $etudiant;
var $winLabel;



var liste = [
'Alfred Robin',
'Bürki Pierre',
'Chappuis Julien',
'Da Silva David',
'Jeanneret Loïck',
'Jeannet Nino',
'Laipe Kevin',
'Latino	Nathan',
'Leuba John',
'Peiris Sébastien',
'Rihs David',
'Rosca Sol',
'Schaffner Téo',
'Seuret	Tristan',
'Vallat	Jonas',
'Loison	Yohan',
'Bueche Erwan']

$(function () {
	$etudiant = $('#etudiant');
	$winLabel = $('#win_label');
	$winLabel.hide();
	
	$start = $('#startButton');
	
	$start = $('#startButton');
	
	$start.on('click', function () {
		testIntervall();
		$start.attr("disabled", "disabled");
		$winLabel.hide();
	})
	
	
	
})

var testIntervall = function () {
	
	let el = generateHugeListForIteration();
	var randomPick = Math.floor(Math.random() * (80 - 1 + 1) + 1);
	var count = 0;
	
	let interval = setInterval(gen => {
	  const { value, done } = gen.next()
	  
	  if (done) {
	    clearInterval(interval)
	  }else if(count == randomPick){
		  $winLabel.show();
		  clearInterval(interval);
		  $start.removeAttr("disabled");
	  } 
	  else {
		  $etudiant.html(value);
		  count ++;
	  }
	}, 200, el[Symbol.iterator]())
}

var generateHugeListForIteration = function () {
	
	
	return liste.concat(liste, liste, liste, liste);
	
}