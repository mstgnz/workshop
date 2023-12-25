<!DOCTYPE html>
<html lang="en-US">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="sa_site" content="1" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Auto Capitalize Sentences</title>
    <meta name="description"
        content="Auto Capitalize Sentences is a free online tool that auto capitalizes the first letter of every sentence." />
    <meta name="keywords" content="auto capitalize, auto capitalize sentences, capitalize first letter of every sentence, capitalize first letter, capitalize, sentence capitalization, capitalize sentences." />
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
            <h1 class="teeshirt-page-title text-uppercase"> Auto Capitalize Sentences </h1><textarea id="character-box"
                style="width:100%; height: 400px; margin-bottom: 30px"
                placeholder="You can start typing here or copy and paste your document and automatically capitalize the first word in each sentence..."></textarea>
            <div style="clear:both"></div>
            <div class="well">
                <p>I don't know if you're like me, but I have a habit of not capitalizing the first words in sentences
                    when I'm writing. It's not on purpose, but there always seems to be one or two sentences where I
                    miss the "shift" key and the first letter in the first word of a new sentence remains small. If you
                    find that you often fail to capitalize sentences correctly when you type, it would be nice to have a
                    tool that would check your work.</p>
                <p>There is nothing worse than accidentally forgetting to capitalize the first word of a sentence in an
                    important letter or correspondence you need to send out. Or when you have an essay due when grammar
                    and punctuation count. It looks unprofessional. Leaving the first word of a sentence small isn't the
                    first impression of your writing you want to make. It's for that reason we have created this auto
                    capitalization tool.</p>
                <p>This tool does exactly what it says it will do. If you have already typed up a paper or essay, you
                    can copy and paste it into the tool and it will instantly capitalize the first letter of every new
                    sentence. If you simply don't like hitting the "shift" key when you are writing, you can type
                    directly into the tool and it will make every letter after a sentence ends big without you ever
                    having to hit that shift key.</p>
                <p>In addition to capitalizing words after the end of a sentence, this tool also automatically
                    capitalizes the word "I" when it's accidentally written as "i". This includes conjunctions that
                    include "I" such as I'm, I've and I'll.</p>
                <p>Even when proofreading, it can get difficult to catch these little mistakes. This is especially true
                    when you have spent a long time writing and revising several drafts. After spending hours on a
                    specific piece of writing, you begin to see what you want to see rather than what's actually on the
                    paper. This is another reason it can be difficult to catch these capitalization mistakes and why
                    this auto capitalization tool can be so useful.</p>
                <p>We're always striving to improve our tools and make them relevant to those who use them. If you feel
                    there is something we can do to make this tool better, please use the contact link at the bottom of
                    the page to let us know. You can also use the "Suggest a Feature" link at the top of the page for
                    this purpose. If there is a feature that you would like to see, there's a good chance that others
                    using the tool would also benefit from it. Since people use our tools in different ways, we can't
                    always anticipate the best features to add and that's where your suggestions can be of great help.
                </p>
            </div>
        </div>
    </div>
    
    <?php include('./footer.php');?>
    <script src="./min/9eb2e76ec9e05765cf687e96f02b04d55854e042.js"></script>
    <script src="./js/footer.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function () {
            var words_with_capital_first_letter = {
                "i": "I",
                "i'll": "I'll",
                "i've": "I've",
                "i'd": "I'd",
                "i'm": "I'm",
                "earth": "Earth"
            };
            var box = $('#character-box');
            function go() {
                var text = box.val();
                text = text.toSentenceCase();
                $.each(words_with_capital_first_letter, function (key, value) {
                    text = text.replace(" " + key + " ", " " + value + " ")
                        .replace(" " + key + ".", " " + value + ".")
                        .replace(" " + key + "!", " " + value + "!")
                        .replace(" " + key + "?", " " + value + "?")
                        .replace(" " + key + "\"", " " + value + "\"");
                });
                box.val(text);
            }
            box.keypress(go).blur(go).focus(go).change(go).keyup(go).keydown(go).load(go);
        })
    </script>
   
</body>

</html>