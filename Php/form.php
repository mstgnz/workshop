<?php
	if($_POST){
		
		if(isset($_POST["corba"])) array_push($orders, $corba[$_POST["corba"]]);
		if(isset($_POST["yemek"])){
			foreach ($_POST["yemek"] as $key => $value) {
				array_push($orders, $yemek[$value]);
			}
		}
		if(isset($_POST["tatlı"])) array_push($orders, $tatli[$_POST["tatlı"]]);

		$adsoyad = $_POST['adsoyad'];
		$cinsiyet = $_POST['cinsiyet'];
		$diller = "";
		if(isset($_POST['dil'])){
			foreach ($_POST['dil'] as $key => $value) {
				$diller .= $value.", ";
			}
		}
		$diller = trim($diller, ", ");
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
			<div class="col-md-10 offset-1 mt-5">
			<form method="post" id="form">
				<div class="form-group">
					<label>İsim Soyisim</label>
					<input type="text" class="form-control" name="adsoyad" placeholder="Adınız Soyadınız">
				</div>
				<fieldset class="border p-2 mb-3">
					<legend class="w-auto">Cinsiyetiniz</legend>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="cinsiyet" id="erkek" value="Erkek" />
						<label class="form-check-label" for="erkek">Erkek</label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="cinsiyet" id="kadin" value="Kadın" />
						<label class="form-check-label" for="kadin">Kadın</label>
					</div>
				</fieldset>
				<fieldset class="border p-2 mb-3">
					<legend class="w-auto">Bildiğiniz Diller</legend>
					<div class="form-check">
						<input class="form-check-input" type="checkbox" name="dil[]" id="almanca" value="Almanca" />
						<label class="form-check-label" for="almanca">Almanca</label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="checkbox" name="dil[]" id="ingilizce" value="İngilizce" />
						<label class="form-check-label" for="ingilizce">İngilizce</label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="checkbox" name="dil[]" id="cince" value="Çince" />
						<label class="form-check-label" for="cince">Çince</label>
					</div>
				</fieldset>
				<input type="reset" class="btn btn-info" value="Temizle" />
				<input type="button" class="btn btn-primary" value="Kaydet" />
			</form>
			<p>
				<div><?php echo $adsoyad ? 'Adınız Soyadınız : '.$adsoyad : "" ?></div>
				<div><?php echo $cinsiyet ? 'Cinsiyetiniz : '.$cinsiyet : "" ?></div>
				<div><?php echo $diller ? 'Bildiğiniz Diller : '.$diller : "" ?></div>
			</p>
			</div>
		</div>
	</div>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function(){
			$('input[type=button]').on('click',function(e){
				var adsoyad = $('input[name="adsoyad"]');
				if(adsoyad.val()==""){adsoyad.css('border-color','red')}else{adsoyad.css('border-color','green')};
				if(adsoyad.val()){
					$('#form').submit();
				}
			});
		});
	</script>
</body>
</html>
