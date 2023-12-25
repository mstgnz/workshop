<?php
	$this->Html->css('/css/cropper.css', array('block' => 'cssTop'));
    $this->Html->script('/js/cropper.js', array('block' => 'scriptBottom'));
?>
<input type="hidden" name="base64" value="" />
<input type="hidden" name="image" value="" />
<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
    <div class="modal-content">
        <div class="modal-header">
        <h5 class="modal-title" id="modalLabel">Resmi Boyutlandır</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
        </div>
        <div class="modal-body">
        <div class="img-container">
            <img id="image" src="https://avatars0.githubusercontent.com/u/3456749" style="max-width: 100%;">
        </div>
        </div>
        <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
        <button type="button" class="btn btn-primary" id="crop">Crop</button>
        </div>
    </div>
    </div>
</div>
<script type="application/javascript">
$(document).ready(function(){
    var image = document.getElementById('image');
    var input = document.querySelector('input[type=file]') //document.getElementById('file-image');
    var $modal = $('#modal');
    var cropper;

    //$('[data-toggle="tooltip"]').tooltip();

    input.addEventListener('change', function(e){
        $('input[name=image]').val(e.target.value.split('\\')[2]);
        var files = e.target.files;
        var done = function(url){
            //input.value = '';
            image.src = url;
            $modal.modal('show');
        };
        var reader;
        var file;
        var url;

        if (files && files.length > 0) {
            file = files[0];
            if (URL) {
                done(URL.createObjectURL(file));
            } else if (FileReader) {
                reader = new FileReader();
                reader.onload = function(e){
                    done(reader.result);
                };
                reader.readAsDataURL(file);
            }
        }
    });

    $modal.on('shown.bs.modal', function(){
        cropper = new Cropper(image, {
            dragMode: 'move',
            aspectRatio: 5 / 7,
            autoCropArea: 1,
            restore: false,
            guides: false,
            center: false,
            highlight: false,
            cropBoxMovable: false,
            cropBoxResizable: false,
            toggleDragModeOnDblclick: false,
            //zoomable: false
        })
    }).on('hidden.bs.modal', function(){
        cropper.destroy();
        cropper = null;
    });

    document.getElementById('crop').addEventListener('click', function(){
        var initialAvatarURL;
        var canvas;
        $modal.modal('hide');
        if (cropper) {
            var image = new Image();
            image.src = cropper.getCroppedCanvas().toDataURL('image/png');
            var height = $('.carousel-inner').height();
            var width = $('.carousel-inner').width();
            $('.carousel-inner').append(`
                <div class="item">
                    <img src="${image.src}" alt="test" style="display:block;height:${height}px;width:${width}px"/>
                </div>
            `);
            $('input[name=base64]').val(image.src);
        }
    });
});
</script>
