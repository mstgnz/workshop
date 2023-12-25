<!DOCTYPE html>
<html lang="en-US">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="sa_site" content="1" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Editor Counter</title>
    <meta name="description" content="Edit Counter is a free online calculator that shows the increase or decrease in words and characters when editing." />
    <meta name="keywords" content="edit counter, editing calculator, editing tool" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="apple-touch-icon" sizes="180x180" href="/images/apple-touch-icon.png" />
    <meta name="msapplication-TileColor" content="#202020" />
    <meta name="msapplication-TileImage" content="/images/icon-144.png" />
    <link rel="stylesheet" type="text/css" href="./css/style.css" />
    <link href="./min/2f967b4c3161059a509ec54e41901a3c4f9a3ded.css" rel="stylesheet" />
</head>

<body>
    <div id="globalPreloader" style="display:none;position:fixed;top:51px;left:0px;right:0px;height:3px;z-index:9999;">
        <div style="width:30%;height:100%;background-color:#0066ff">&nbsp;</div>
    </div>
    <script type="text/javascript">
        document.getElementById('globalPreloader').style.display = 'block';
    </script>
    
    <div id="fb-root"></div>
    <div id="data-block" data-log-url="/site/log" data-spell-check-url="/site/proxy?url=" data-css-path="/css/"></div>
    
    <?php include('./navbar.php'); ?>
    
    <div class="container">
        <div class="mb100">
            <h1 class="teeshirt-page-title text-uppercase"> Edited Words and Edited Characters </h1>
            <h3 style="position: relative;"><span class="label label-primary words">0</span> words <span
                    class="label label-primary edited_words" style="display: none;">+0</span> <span class="edited"
                    style="display: none;">edited</span> &nbsp;&nbsp;&nbsp;
                <span class="label label-primary characters">0</span> characters <span
                    class="label label-primary edited_characters" style="display: none;">+0</span> <span class="edited"
                    style="display: none;">edited</span><button type="button" class="btn btn-default"
                    id="start_over">Start Over</button></h3><textarea id="edit-counter-box"
                style="width:100%; height: 400px;"></textarea>
            <div style="clear:both"></div>
            <div class="well" style="margin-top:20px">
                <p>Many people assume good writing is found when you write. The truth is for most writers, good writing
                    appears when you edit. You know you have become serious about your writing when you're proud of the
                    number of words you're able to reduce from your rough drafts when editing. To help you see how well
                    you've been editing, we wanted to create a counter which encourages writers to reduce their word
                    count through editing, and the result is the Edit Counter.</p>
                <p>The tool is easy to use. Simply paste your writing into the text area, and then hit the "Start Over"
                    button on the top right of the tool. This will still show you the number of words written, but it
                    will reset the "edit" word and character counters to +0. When you begin editing your writing, the
                    Edit Counter will show how many words your writing had decreased or increased through your editing.
                </p>
                <p>Editing is an important part of the writing process, and it usually doesn't get the respect it
                    deserves. If you're able to get your point across more succinctly, that's good writing. While many
                    writers strive to up their word count as much as possible, it's essential to remember that word
                    count is only important if the words written actually count. Getting rid of those filler words and
                    tightening up your writing should be a celebrated and encouraged exercise, not something to be
                    dreaded.</p>
                <p>Using Edit Counter is also a great way to see the effect editing has on your writing, especially over
                    time. When using the tool on a regular basis, you may begin to see a trend that your editing
                    decreases or increases your word count a certain percentage for every 1000 words written. If you
                    become attuned to this trend, you will know how much you need to write in your first drafts to meet
                    the required word count once you have finished editing.</p>
            </div>
        </div>
    </div>
    
    <?php include('./footer.php');?>
    <script src="./min/9eb2e76ec9e05765cf687e96f02b04d55854e042.js"></script>
    <script src="./js/footer.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function () {
            var cookieObject = {
                "start_word_count": '0',
                "start_character_count": '0'
            };
            var flag = false;
            var text = '';
            box = $('#edit-counter-box');
            if ($.cookie('text_for_edit_counter')) {
                box.text($.cookie('text_for_edit_counter'));
            }
            if (!$.cookie('start_counts')) {
                box.keypress(countCharsAndWordsCounts)
                    .blur(countCharsAndWordsCounts)
                    .focus(countCharsAndWordsCounts)
                    .change(countCharsAndWordsCounts)
                    .keyup(countCharsAndWordsCounts)
                    .keydown(countCharsAndWordsCounts)
                    .load(countCharsAndWordsCounts);
                box.focus();
            }
            else {
                box.keypress(countEditedCharsAndWordsCounts)
                    .blur(countEditedCharsAndWordsCounts)
                    .focus(countEditedCharsAndWordsCounts)
                    .change(countEditedCharsAndWordsCounts)
                    .keyup(countEditedCharsAndWordsCounts)
                    .keydown(countEditedCharsAndWordsCounts)
                    .load(countEditedCharsAndWordsCounts);
                box.focus();
            }
            /**
            * Counts words and characters of text
            * @param text
            * @returns {{chars: *, words: *}}
            */
            function charsAndWords(text) {
                var chars = text.match(/(?:[^\r\n]|\r(?!\n))/g);
                var words = text.replace(/[,;.!:—\/]/g, ' ').replace(/[^a-zA-Z\d\s&:]/g, '').match(/\S+/g); //be smarter for latin languages
                return { chars: chars, words: words };
            }
            /**
            * Counts and displays words and characters of text written in textarea
            * @returns {undefined}
            */
            function countCharsAndWordsCounts() {
                if (flag) {
                    countEditedCharsAndWordsCounts();
                }
                else {
                    text = box.val();
                    $.cookie('text_for_edit_counter', text, { expires: 365 });
                    var counts = charsAndWords(text);
                    if (counts.chars != undefined && counts.words != null) {
                        $('.characters').text(counts.chars.length);
                        $('.words').text(counts.words.length);
                        cookieObject.start_character_count = counts.chars.length;
                        cookieObject.start_word_count = counts.words.length;
                    }
                    else {
                        $('.characters').text(0);
                        $('.words').text(0);
                        cookieObject.start_character_count = 0;
                        cookieObject.start_word_count = 0;
                    }
                    $.cookie('start_counts', JSON.stringify(cookieObject), { expires: 365 });
                }
            }
            /**
            * Counts and displays words and characters, which were added to the textarea
            * @returns {undefined}
            */
            function countEditedCharsAndWordsCounts() {
                text = box.val();
                $.cookie('text_for_edit_counter', text, { expires: 365 });
                cookieObject = JSON.parse($.cookie('start_counts'));
                var counts = charsAndWords(text);
                $('.edited, .edited_words, .edited_characters').show();
                if (counts.chars != undefined && counts.words != null) {
                    var chars_count = counts.chars.length - cookieObject.start_character_count;
                    var words_count = counts.words.length - cookieObject.start_word_count;
                    $('.characters').text(counts.chars.length);
                    $('.words').text(counts.words.length);
                    if (chars_count >= 0) {
                        chars_count = '+' + chars_count;
                        $('.edited_characters').text(chars_count);
                    }
                    else {
                        $('.edited_characters').text(chars_count);
                    }
                    if (words_count >= 0) {
                        words_count = '+' + words_count;
                        $('.edited_words').text(words_count);
                    }
                    else {
                        $('.edited_words').text(words_count);
                    }
                }
                else {
                    $('.characters').text(0);
                    $('.words').text(0);
                    if (cookieObject.start_character_count == 0)
                        $('.edited_characters').text('+0');
                    else
                        $('.edited_characters').text(0 - cookieObject.start_character_count);
                    if (cookieObject.start_word_count == 0)
                        $('.edited_words').text('+0');
                    else
                        $('.edited_words').text(0 - cookieObject.start_word_count);
                }
            }
            $('#start_over').click(function () {
                flag = true;
                text = box.val();
                var counts = charsAndWords(text);
                $('.edited, .edited_words, .edited_characters').show();
                if (counts.chars != undefined && counts.words != null) {
                    cookieObject.start_character_count = counts.chars.length;
                    cookieObject.start_word_count = counts.words.length;
                }
                else {
                    cookieObject.start_character_count = 0;
                    cookieObject.start_word_count = 0;
                }
                $('.edited_characters').text('+0');
                $('.edited_words').text('+0');
                $.cookie('start_counts', JSON.stringify(cookieObject), { expires: 365 });
                box.focus();
            });
        });
    </script>
    
</body>

</html>