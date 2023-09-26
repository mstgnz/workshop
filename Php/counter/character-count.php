<!DOCTYPE html>
<html lang="en-US">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="sa_site" content="1" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Character Counter</title>
    <meta name="description" content="Character Count is a free online tool that calculates the number of characters and words written in your writing." />
    <meta name="keywords" content="character counter, character count, letter count" />
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
        <div class="container">
            <div class="mb100">
                <div class="row">
                    <h1 class="teeshirt-page-title text-uppercase"> Character Counter </h1>
                    <div class="col-md-10">
                        <h3>Characters <span class="label label-primary characters">0</span> Words <span
                                class="label label-primary words">0</span> Lines <span
                                class="label label-primary lines">0</span></h3>
                        <form data-persist="garlic" method="POST">
                            <textarea id="character-box" class="form-control"
                                style="width:100%; height: 400px;"></textarea>
                            <div style="clear:both"></div>
                            <textarea class="form-control table-data finalResult" id="for_counting_lines" rows="1"
                                style="visibility: hidden; height: 1px; padding:3px"></textarea>
                        </form>
                    </div>
                    <div class="col-md-2">
                        <div class="panel-group" id="accordion">
                            <div class="panel panel-default" style="margin: 55px 0 0 0" id="letter-density">
                                <div class="panel-heading">
                                    <h3 class="panel-title">
                                        <a class="accordion-toggle" data-toggle="collapse" data-target="#ld-accordion"
                                            href="#" onclick="event.preventDefault();">
                                            Letter Density
                                        </a>
                                    </h3>
                                </div>
                                <div id="ld-accordion" class="list-group panel-collapse collapse">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="well" style="margin-top:20px">
                        <p>Character Counter is a 100% free online character count calculator that's simple to use.
                            Sometimes users prefer simplicity over all of the detailed writing information Word Counter
                            provides, and this is exactly what this tool offers. It displays character count and word
                            count which is often the only information a person needs to know about their writing. Best
                            of all, you receive the needed information at a lightning fast speed.</p>
                        <p>To find out the word and character count of your writing, simply copy and paste text into the
                            tool or write directly into the text area. Once done, the free online tool will display both
                            counts for the text that's been inserted. This can be useful in many instances, but it can
                            be especially helpful when you are writing for something that has a character minimum or
                            limit.</p>
                        <p>Character and word limits are quite common these days on the Internet. The one that most
                            people are likely aware of is the 140 character limit for tweets on Twitter, but character
                            limits aren't restricted to Twitter. There are limits for text messages (SMS), Yelp reviews,
                            Facebook posts, Pinterest pins, Reddit titles and comments, eBay titles and descriptions as
                            well as many others. Knowing these limits, as well as being able to see as you approach
                            them, will enable you to better express yourself within the imposed limits.</p>
                        <p>For students, there are usually limits or minimums for homework assignments. The same is
                            often true for college applications. Abiding by these can have a major impact on how this
                            writing is graded and reviewed, and it shows whether or not you're able to follow basic
                            directions. Character counter can make sure you don't accidentally go over limits or fail to
                            meet minimums that can be detrimental to these assignments.</p>
                        <p>This information can also be quite helpful for writers. Knowing the number of words and
                            characters can help writers better understand the length of their writing, and work to
                            display the pages of their writing in a specific way. For those who write for magazines and
                            newspapers where there is limited space, knowing these counts can help the writer get the
                            most information into that limited space.</p>
                        <p>For job seekers, knowing the number of characters of your resume can be essential to get all
                            the information you want onto a single page. You can fool around with different fonts, their
                            sizes and spacing to adjust the number of characters you can fit on a single page, but it's
                            important to know the number you're attempting to fit on the page.</p>
                        <p>Character Counter isn't only for English. The tool can be helpful for those writing in
                            non-English languages where character count is important. This can be the case for languages
                            Japanese, Korean, Chinese and many others where characters are the basis of the written
                            language. Even for those who aren't writing in English, knowing the character count of the
                            writing is often beneficial to the writing.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <?php include('./footer.php');?>
    <script src="./min/f9012701b486228b3731ee502901ddcd22acc45c.js"></script>
    <script src="./js/footer.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function () {

            $(document).ready(function () {
                $('#ld-accordion').collapse('show');
                setTimeout(function () {
                    $('#character-box').focus();
                }, 500);
            });
            var box = $('#character-box');
            //    box.css('resize', 'vertical');
            var box_for_counting_lines = $('#for_counting_lines');
            box_for_counting_lines.css({
                'padding': box.css('padding'),
                'padding-top': 0,
                'padding-bottom': 0,
                'overflow': 'hidden',
                'width': box.css('width'),
                'line-height': box.css('line-height')
            });
            var line_height = box.css('line-height');
            line_height = line_height.split('.')[0];
            line_height = Number(line_height.replace(/\D/g, ''));

            /**
             * Counts lines of text in textarea
             */
            function countLines() {
                var text = box.val();
                box_for_counting_lines.val(text);
                var actualHeight = box_for_counting_lines[0].scrollHeight;
                if (text != '') {
                    $('.lines').text(Math.round(actualHeight / line_height));
                }
                else {
                    $('.lines').text(0);
                }

            }

            /**
             * Counts characters and words of text in textarea
             */
            function go() {
                var text = box.val();
                var chars = text.match(/(?:[^\r\n]|\r(?!\n))/g);
                var text_without_space = text.replace(/\s+/g, '');
                var words;
                var matches = text_without_space.match(/([^\x00-\x7F\u2013\u2014])+/gi);
                var latin_only = (matches === null);
                if (latin_only == false) //non latin languages like chinese and russian - just count the spaces and be done with it
                {
                    words = text.match(/\S+/g);
                }
                else {
                    words = text.replace(/[;!:—\/]/g, ' ').replace(/\.\s+/g, ' ').replace(/[^a-zA-Z\d\s&:,]/g, '').replace(/,([^0-9])/g, ' $1').match(/\S+/g); //be smarter for latin languages
                }
                if (chars != undefined && chars != null) {
                    $('.characters').text(chars.length);
                    $('.words').text(words.length);
                }
                else {
                    $('.characters').text(0);
                    $('.words').text(0);
                }
            }

            /**
             *  Checks if the given value exists in array
             */
            Array.prototype.contains = function (v) {
                for (var i = 0; i < this.length; i++) {
                    if (this[i] === v) return true;
                }
                return false;
            };

            /**
             * Returns array with unique values
             */
            Array.prototype.unique = function () {
                var arr = [];
                for (var i = 0; i < this.length; i++) {
                    if (!arr.contains(this[i])) {
                        arr.push(this[i]);
                    }
                }
                return arr;
            };

            /**
             * Shows the letters used
             */
            function letterDensity() {
                var text = box.val().toUpperCase();
                var letters = text.match(/[^\s]/g);
                letters = letters !== null ? letters : [];
                var uniqueLetters = letters.unique();
                var lettersNumber = [];
                var uniqueLettersLength = uniqueLetters.length;
                var lettersLength = letters.length;
                var count, percentage, i, j;
                var ldAccordion = $('#ld-accordion');
                ldAccordion.empty();
                for (i = 0; i < uniqueLettersLength; i++) {
                    count = 0;
                    for (j = 0; j < lettersLength; j++) {
                        if (uniqueLetters[i] === letters[j]) {
                            count++;
                        }
                    }
                    lettersNumber.push([uniqueLetters[i], count]);
                }
                lettersNumber.sort(
                    function (a, b) {
                        return b[1] - a[1];
                    });
                var lettersNumberLength = lettersNumber.length;
                var limit = lettersNumberLength < 10 ? lettersNumberLength : 10;
                for (i = 0; i < limit; i++) {
                    percentage = (100 * (lettersNumber[i][1] / lettersLength)).toFixed(0);
                    ldAccordion.append('<span class="list-group-item" href="#"><span class="badge"> ' + lettersNumber[i][1] + ' (' + percentage + '%)</span><span class="word">' + lettersNumber[i][0] + '</span></span>');
                }
            }

            $(window).resize(function () {
                box_for_counting_lines.css('width', box.css('width'));
                countLines();
            });

            box.keypress(function () {
                go();
                countLines();
                letterDensity();
            }).blur(function () {
                go();
                countLines();
                letterDensity();
            }).focus(function () {
                go();
                countLines();
                letterDensity();
            }).change(function () {
                go();
                countLines();
                letterDensity();
            }).keyup(function () {
                go();
                countLines();
                letterDensity();
            }).keydown(function () {
                go();
                countLines();
                letterDensity();
            }).load(function () {
                go();
                countLines();
                letterDensity();
            });

        });
    </script>
    
</body>
</html>