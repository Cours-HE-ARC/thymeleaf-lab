/**
 * 
 */

var $etudiant;
var $winLabel;



var liste = [
'Barbot Mathieu',
'Boegli Lenny',
'Campana Luca',
'Costa Bruno',
'Faivre Corentin',
'Ferro Massimo',
'Flück Thierry',
'Frossard Loïc',
'Girardin Jarod',
'Izzo Valentino',
'Lopes da Silva Diogo',
'Meyer Luca Davide',
'Montavon Alexia',
'Muller Leon',
'Tripiciano Tania',
'Wermeille Thibault']

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