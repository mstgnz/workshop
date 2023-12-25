<!DOCTYPE html>
<html lang="en-US">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="sa_site" content="1" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Random Word Generator</title>
    <meta name="description"
        content="The free online random word generator tool allows you to create any number of random words you need for your project. Choose the number of random words you want to generate and click the button to display them." />
    <meta name="keywords" content="word count, word counter, writing, keyword frequency, character count, spell check, thesaurus" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="apple-touch-icon" sizes="180x180" href="/images/apple-touch-icon.png" />
    <meta name="msapplication-TileColor" content="#202020" />
    <meta name="msapplication-TileImage" content="/images/icon-144.png" />
    <link rel="stylesheet" type="text/css" href="./css/style.css" />
    <link href="./min/ec9c3a7259ea00a375fb713a5497d5ea0342b249.css" rel="stylesheet" />
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
            <h1 class="teeshirt-page-title text-uppercase"> Random Word Generator </h1>
            <div class="row">
                <div class="col-lg-12">
                    <div class="well">
                        <p style="margin-bottom: 0">Click the button below to generate
                            <input type="number" min="1" value="5" class="form-control input-sm"
                                id="random_words_count">
                            random</p>
                        <div class="col-md-12" style="margin-bottom: 10px">
                            <div><input type="radio" name="word_type" checked id="all_words"><label for="all_words"
                                    style="margin-left: 5px">Words (All)</label></div>
                            <div><input type="radio" name="word_type" id="verbs"><label for="verbs"
                                    style="margin-left: 5px">Verbs only</label></div>
                            <div><input type="radio" name="word_type" id="nouns"><label for="nouns"
                                    style="margin-left: 5px">Nouns only</label></div>
                            <div><input type="radio" name="word_type" id="adjectives"><label for="adjectives"
                                    style="margin-left: 5px">Adjectives only</label></div>
                        </div><input type="button" id="random-words" name="random-words" value="Generate Random Words"
                            class="btn btn-default" onclick="randomWordGenerator();">
                        <p id="wordList"></p>
                        <div style="color:#666666;">Click on a word you like if you want to temporarily store it in the
                            box below.</div>
                    </div>
                    <div class="well">
                        <p>Your Word List</p>
                        <div id="wordPen" class="online-tools"></div><textarea id="textarea_for_coping_words" rows="5"
                            class="form-control"></textarea><input type="button" value="Clear The Words"
                            class="btn btn-default" onclick="clearDiv();" style="margin-top: 10px"><input type="button"
                            value="Copy Words" class="btn btn-default" onclick="copyWords();"
                            style="margin-top: 10px; margin-left: 5px">
                    </div>
                </div>
            </div>
            <div style="clear:both"></div>
            <div class="well" style="margin-top:20px">
                <h3>What is it?</h3>
                <p>The Random Word Generator is a tool to help you create a list of random words. There are many reasons
                    one might be interested in doing this, and you're likely here because you're interested in creating
                    a random word list. This tool can help you do exactly that.</p>
                <p>The tool is easy to use. All you need to do is choose the number of words you want to create (the
                    default is five, but you can input any number you'd like) and the type of words you want. You can
                    choose from all words, verbs only, nouns only or adjective only depending on which best meets your
                    needs. </p>
                <p>Once done, you simply press the &quot;Generate Random Words&quot; button and a list of words will
                    appear. You can use this list or you can scan them and choose the ones you want to keep by clicking
                    on them. This will place them in the &quot;Your Word List&quot; area and you can build a new list
                    that meets your needs. </p>
                <p>Below you'll find some of the common ways this tool can be used.</p>
                <p>
                    <h3>Creative Writing</h3>
                </p>
                <p>This tool can be a great way to generate creative writing ideas. For example, you could generate 20
                    random words and then incorporate all of them into a story. This will force you to think creatively
                    since you have no idea what words will appear. You can also play with this to make it more difficult
                    if you desire. For example, you could create the story using the 20 words in the exact order they
                    were randomly generated to make it more of a challenge. This is one example of how writers might use
                    the tool to push their writing.</p>
                <p>
                    <h3>Teachers &amp; Students</h3>
                </p>
                <p>Teachers can use this tool to help create vocabulary tests or challenging students to correctly use
                    words in a sentence. For students, they can use it to study for spelling bees, build their
                    vocabulary and learn new words. Both can use it to improve creativity by using it to foster creative
                    writing.</p>
                <p>
                    <h3>Games</h3>
                </p>
                <p>For those who plays games like Pictionary, this can be a great tool to use for the game. With words
                    being randomly generated, it keeps the game fair and honest. It can also be a fun way for kids to
                    fill in MadLibs to produce results that the children may not have ever considered. The tool can
                    benefit any game which may need words as part of it.</p>
                <p>
                    <h3>Creating Names</h3>
                </p>
                <p>The generator can be an excellent way to brainstorm new names. By generating random words, the tool
                    can help spark your creativity by producing words you may not have come up with on your own when
                    working on various projects. For example, the tool can help you come up with product names, naming a
                    band or group, creating an event name or any other naming process where you're looking for
                    inspiration.</p>
                <p>The above examples are just a few ways this tool can be used. If you find this tool useful, please
                    let us know. We're always interested in learning how people use our tools. We also welcome any
                    suggestions you might have to make it better.</p>
            </div>
        </div>
    </div>
    
    <?php include('./footer.php');?>
    <script src="./min/b3e3af0a976d9c569831ddf705e97bece8383de9.js"></script>
    <script src="./js/footer.js"></script>
</body>
</html>