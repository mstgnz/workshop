<?php
	$corba = [
		"mercimek"	=> "Mercimek",
		"ezogelin"	=> "Ezogelin",
		"yayla"		=> "Yayla",
		"iskembe"	=> "İşkembe"
	];
	$yemek = [
		"pilav"			=> "Pilav",
		"taskebabi"		=> "Tas Kebabı",
		"kurufasulye"	=> "Kuru Fasulye",
		"etkavurma"		=> "Et Kavurma",
		"patlicankebap"	=> "Patlıcan Kebap",
		"doner"			=> "Döner",
		"etsote"		=> "Et Sote",
		"turlu"			=> "Türlü"
	];
	$tatli = [
		"kadayif" 	=> "Kadayıf",
		"kemalpasa"	=> "Kemalpaşa",
		"kunefe"	=> "Künefe",
		"sutlac"	=> "Sütlaç",
		"baklava"	=> "Baklava"
	];

	function yiyecekler($arr=""){
		global $corba, $yemek, $tatli;
		if($arr=="çorba") $arr = $corba;
		if($arr=="yemek") $arr = $yemek;
		if($arr=="tatlı") $arr = $tatli;
		return $arr;
	}

	if($_POST){
		$orders = [];
		if(isset($_POST["corba"])) array_push($orders, $corba[$_POST["corba"]]);
		if(isset($_POST["yemek"])){
			foreach ($_POST["yemek"] as $key => $value) {
				array_push($orders, $yemek[$value]);
			}
		}
		if(isset($_POST["tatlı"])) array_push($orders, $tatli[$_POST["tatlı"]]);
	}

?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" />
	<title>Yemek Siparişi</title>
	<style>
		*{ outline: none; }
		.input-group-text{ width: 100px; }
		.form-control:focus{ box-shadow: none; }
		form{ margin-bottom:50px;}
		/* Chrome, Safari, Edge, Opera */
		input::-webkit-outer-spin-button,
		input::-webkit-inner-spin-button {
		-webkit-appearance: none;
		margin: 0;
		}

		/* Firefox */
		input[type=number] {
		-moz-appearance: textfield;
		}
	</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-10 offset-1">
			<form method="post" id="form">
				<div class="row">
				<div class="col-md-4">
					<div class="jumbotron mt-3 p-3">
						<div class="form-group">
							<label for="exampleFormControlInput1">Ad Soyad</label>
							<input type="text" class="form-control" name="adsoyad" placeholder="Adınız Soyadınız">
						</div>
						<div class="form-group">
							<label for="exampleFormControlInput1">Adres</label>
							<input type="text" class="form-control" name="adres" placeholder="Adresiniz">
						</div>
						<div class="form-group">
							<label for="exampleFormControlInput1">Telefon</label>
							<input type="number" class="form-control" name="tel" placeholder="Telefonunuz">
						</div>
					</div>
					<div class="card">
						<div class="card-header p-2">Siparişiniz</div>
						<ul class="list-group list-group-flush">
							<?php 
							if($orders){
								foreach ($orders as $key => $value) {
									echo '<li class="list-group-item p-2">'.$value.'</li>';
								}
							}else{
								echo '<li class="list-group-item p-2">Sepet Boş</li>';
							}
							?>
						</ul>
					</div>
				</div>
				<div class="col-md-8">
					<fieldset class="border p-2">
						<legend class="w-auto">Çorbalar</legend>
						<?php foreach (yiyecekler('çorba') as $key => $value) { ?>
							<div class="form-check">
								<input class="form-check-input" type="radio" name="corba" id="<?php echo $key; ?>" value="<?php echo $key; ?>" />
								<label class="form-check-label" for="<?php echo $key; ?>"><?php echo $value; ?></label>
							</div>
						<?php }?>
					</fieldset>
					<fieldset class="border p-2">
						<legend class="w-auto">Yemekler</legend>
						<table>
							<tr>
							<td>
							<?php foreach (yiyecekler('yemek') as $key => $value) { ?>
							<div class="form-check">
								<input class="form-check-input" type="checkbox" name="yemek[]" id="<?php echo $key; ?>" value="<?php echo $key; ?>" />
								<label class="form-check-label" for="<?php echo $key; ?>"><?php echo $value; ?></label>
							</div>
							<?php }?>
							</td>
							</tr>
						</table>
					</fieldset>
					<fieldset class="border p-2">
						<legend class="w-auto">Tatlılar</legend>
						<?php foreach (yiyecekler('tatlı') as $key => $value) { ?>
							<div class="form-check">
								<input class="form-check-input" type="radio" name="tatlı" id="<?php echo $key; ?>" value="<?php echo $key; ?>" />
								<label class="form-check-label" for="<?php echo $key; ?>"><?php echo $value; ?></label>
							</div>
						<?php }?>
					</fieldset>
					<input type="button" class="btn btn-primary mt-2" value="Sipariş Ver" />
				</div>
			</div>
			</form>
			</div>
		</div>
	</div>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function(){
			$('input[type=button]').on('click',function(e){
				var adsoyad = $('input[name="adsoyad"]');
				var adres = $('input[name="adres"]');
				var tel = $('input[name="tel"]');
				if(adsoyad.val()==""){adsoyad.css('border-color','red')}else{adsoyad.css('border-color','green')};
				if(adres.val()==""){adres.css('border-color','red')}else{adres.css('border-color','green')};
				if(tel.val()==""){tel.css('border-color','red')}else{tel.css('border-color','green')};
				if(adsoyad.val() && adres.val() && tel.val()){
					$('#form').submit();
				}
			});
		});
	</script>
</body>
</html>
