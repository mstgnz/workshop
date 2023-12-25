<div id="wc_footer">
    <div class="container">
        <div class="col-md-3">
            <h5><span data-tr-detail="site_map">Site Map</span></h5>
            <ul style="list-style-type: none; padding:0">
                <li><a href="./" data-tr-detail="home">Home</a></li>
                <li><a href="./our-tools" data-tr-detail="more_tools">More Tools</a></li>
            </ul>
        </div>
        <div class="col-md-5">

        </div>
        <div class="col-md-2">
            <h5><span data-tr-detail="follow">Follow</span></h5>
            <ul class="sprite">
                <li class="facebook"><a target="_blank" href="https://www.facebook.com/word">Facebook
                    </a></li>
                <li class="twitter">
                    <a target="_blank" href="https://twitter.com/word">Twitter</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<!-- foundBugModal -->
<div class="modal fade" id="foundBugModal" tabindex="-1" role="dialog" aria-labelledby="foundBugModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="foundBugModalLabel">Found a Bug</h4>
            </div>
            <div class="modal-body"><textarea rows="5" class="form-control" placeholder="What problem do you see?" name="message" id="message"></textarea><button class="btn btn-default" name="send" id="submit" onclick="editor.sendMessage();" style="margin-top: 15px; margin-bottom: 15px">Send</button>
                <div class="alert alert-warning" style="display: none; position: absolute; z-index: 9999; left: 20%; right: 20%;"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>No speech was detected!</strong> You may need to adjust your microphone settings.</div>
                <div class="success" style="display: none;"></div>
            </div>
            <div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">Done</button></div>
        </div>
    </div>
</div>