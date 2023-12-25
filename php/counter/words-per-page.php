<!DOCTYPE html>
<html lang="en-US">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="sa_site" content="1" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Words Per Page: convert words to pages calculator</title>
    <meta name="description" content="Words per Page is a free online words to pages calculator which converts the numbers of words you write into pages and allows you to change margins, font size and fonts." />
    <meta name="keywords" content="words per page" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="apple-touch-icon" sizes="180x180" href="/images/apple-touch-icon.png" />
    <meta name="msapplication-TileColor" content="#202020" />
    <meta name="msapplication-TileImage" content="/images/icon-144.png" />
    <link rel="stylesheet" type="text/css" href="./css/style.css" />
    <link href="./min/145d80644a28bd1c74cae195ac1f7e41216da16f.css" rel="stylesheet" />
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
            <h1 class="teeshirt-page-title text-uppercase"> Welcome to Words per Page </h1><br />
            <div class="row">
                <div class="col-md-12" style="text-align:center;"></div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="top-margin"></div>
                    <form name="calculator">
                        <h3 style="color: #31708f;" onclick="estimationCount();">Enter Total Number of Words</h3>
                        <div class="row">
                            <div class="form-group col-lg-4"><label for="total_words">Total words</label><input
                                    type="text" class="form-control input-sm" id="total_words" name="total_words"
                                    aria-describedby="basic-addon1" value="0" onkeyup="estimationCount();"
                                    onchange="estimationCount();"
                                    onkeydown="if (event.keyCode === 13) { return false; }"></div>
                            <div class="form-group col-sm-2"><label for="choose_font">Choose Font</label><select
                                    name="choose_font" id="choose_font" class="form-control input-sm"
                                    onchange="estimationCount();">
                                    <option selected="selected" value="1">Arial</option>
                                    <option value="0.946">Calibri</option>
                                    <option value="1.277">Comic Sans MS</option>
                                    <option value="1.243">Courier</option>
                                    <option value="1.13">Times New Roman</option>
                                    <option value="1.212">Verdana</option>
                                </select></div>
                            <div class="form-group col-sm-2"><label for="choose_size">Choose Size</label><select
                                    name="choose_size" id="choose_size" class="form-control input-sm"
                                    onchange="estimationCount();">
                                    <option value="1.522">10</option>
                                    <option value="1.206">11</option>
                                    <option selected="selected" value="1">12</option>
                                    <option value="0.859">13</option>
                                    <option value="0.789">14</option>
                                </select></div>
                            <div class="form-group col-sm-2"><label for="choose_spacing">Choose Spacing</label><select
                                    name="choose_spacing" id="choose_spacing" class="form-control input-sm"
                                    onchange="estimationCount();">
                                    <option value="1">single</option>
                                    <option value="1.267">1.5</option>
                                    <option value="1.644">double</option>
                                </select></div>
                        </div>
                        <div class="section-colored text-center alert-info">
                            <div class="container">
                                <div class="row">
                                    <div class="col-lg-12 ">
                                        <h1 id="totalCount1">Pages: 0</h1>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr />
                        <div class="row">
                            <div class="col-md-12 col-sm-12" style="text-align:center;"></div>
                            <div class="col-md-6 col-sm-6" style="text-align:right"></div>
                            <div class="col-md-6 col-sm-6"></div>
                        </div>
                        <hr />
                        <h3 style="color: #31708f;" onclick="estimationPageCount();">Type in your Words</h3>
                        <div class="row">
                            <div class="col-lg-6 no_padding">
                                <div class="form-group col-sm-2 pdr0">
                                    <div class="col-sm-12 no_padding">
                                        <div class="col-sm-12 no_padding"><label>Print</label></div><button
                                            type="button" title="Print" class="btn btn-default btn-md print_button"
                                            onclick="printTextArea();"><span
                                                class="glyphicon glyphicon-print"></span></button>
                                    </div>
                                </div>
                                <div class="form-group col-sm-2 pdr0 pdl0"><label for="page_format">Page
                                        Format</label><select name="page_format" id="page_format"
                                        class="form-control input-sm" onchange="estimationPageCount();">
                                        <option value="59.4 84.1" id="A1">A1</option>
                                        <option value="42.0 59.4" id="A2">A2</option>
                                        <option value="29.7 42.0" id="A3">A3</option>
                                        <option selected="selected" value="21.0 29.7" id="A4">A4</option>
                                        <option value="14.8 21.0" id="A5">A5</option>
                                        <option value="21.59 27.94" id="us_letter">U.S. Letter</option>
                                    </select></div>
                                <div class="form-group col-sm-3 pdr0"><label for="txt_font">Font</label><select
                                        name="txt_font" id="txt_font" class="form-control input-sm"
                                        onchange="estimationPageCount();">
                                        <option selected="selected" value="Arial">Arial</option>
                                        <option value="Calibri">Calibri</option>
                                        <option value="Comic Sans MS">Comic Sans MS</option>
                                        <option value="Courier">Courier</option>
                                        <option value="Times New Roman">Times New Roman</option>
                                        <option value="Verdana">Verdana</option>
                                    </select></div>
                                <div class="form-group col-sm-3 pdr0"><label for="line_spacing">Line
                                        Spacing</label><select name="line_spacing" id="line_spacing"
                                        class="form-control input-sm" onchange="estimationPageCount();">
                                        <option value="1">single</option>
                                        <option value="1.267">1.5</option>
                                        <option value="1.644">double</option>
                                    </select></div>
                                <div class="form-group col-sm-2 pdr0"><label for="page_unit">Units</label><select
                                        name="page_unit" id="page_unit" class="form-control input-sm"
                                        onchange="estimationPageCount();">
                                        <option value="in">inch</option>
                                        <option value="cm">cm</option>
                                    </select></div>
                            </div>
                            <div class="col-lg-6 no_padding">
                                <div class="form-group col-sm-2 font_size pdr0"><label for="txt_size">Font
                                        Size</label><input type="number" class="form-control input-sm" id="txt_size"
                                        name="txt_size" min="0" onchange="estimationPageCount();"
                                        onkeyup="estimationPageCount();"
                                        onkeydown="if (event.keyCode === 13) { return false; }"><span
                                        class="px">px</span></div>
                                <div class="form-group col-sm-10 page_margins pdr0">
                                    <div class="col-sm-3"><label for="top_padding" class="margin_lable">Top
                                            Margin</label><input type="number" class="form-control input-sm"
                                            id="top_padding" name="top_padding" placeholder="Top" min="0" step="0.1"
                                            onchange="estimationPageCount();" onkeyup="estimationPageCount();"
                                            onkeydown="if (event.keyCode === 13) { return false; }"><span
                                            class="inch">inch</span></div>
                                    <div class="col-sm-3"><label for="right_padding" class="right_padding">Right
                                            Margin</label><input type="number" class="form-control input-sm"
                                            id="right_padding" name="right_padding" placeholder="Right" min="0"
                                            step="0.1" onchange="estimationPageCount();"
                                            onkeyup="estimationPageCount();"
                                            onkeydown="if (event.keyCode === 13) { return false; }"><span
                                            class="inch">inch</span></div>
                                    <div class="col-sm-3"><label for="bottom_padding" class="right_padding">Bottom
                                            Margin</label><input type="number" class="form-control input-sm"
                                            id="bottom_padding" name="bottom_padding" placeholder="Bottom" min="0"
                                            step="0.1" onchange="estimationPageCount();"
                                            onkeyup="estimationPageCount();"
                                            onkeydown="if (event.keyCode === 13) { return false; }"><span
                                            class="inch">inch</span></div>
                                    <div class="col-sm-3"><label for="left_padding" class="right_padding">Left
                                            Margin</label><input type="number" class="form-control input-sm"
                                            id="left_padding" name="left_padding" placeholder="Left" min="0" step="0.1"
                                            onchange="estimationPageCount();" onkeyup="estimationPageCount();"
                                            onkeydown="if (event.keyCode === 13) { return false; }"><span
                                            class="inch">inch</span></div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-lg-12 keywordsBox"><label for="txt">Start typing, or copy and
                                    paste your document here...</label><textarea id="txt" name="txt" rows="10"
                                    onkeyup="estimationPageCount();" onchange="estimationPageCount();"
                                    onfocus="estimationPageCount();" class="form-control table-data"
                                    placeholder="Start typing, or copy and paste your document here..."
                                    data-autosize-on="true"></textarea></div>
                        </div>
                        <div class="section-colored text-center alert-info">
                            <div class="container">
                                <div class="row">
                                    <div class="col-lg-12 ">
                                        <h1 id="totalCount2">Pages: 0</h1>
                                    </div>
                                </div>
                            </div>
                        </div><textarea id="hidden_txt"></textarea>
                    </form>
                </div>
            </div>
            <div class="row"><br />
                <div class="row">
                    <div class="col-md-12" style="text-align:center;"></div>
                </div>
                <div class="col-sm-6 introduction">
                    <div class="well">
                        <p>There are times when it helps to know how many words per page you're writing. While a general
                            guideline is one page is 500 words (single spaced) or 250 words (double spaced), this is a
                            ballpark figure. The truth is the number of words per page depends on a variety of factors
                            such as the type of font, the font size, spacing elements, margin spacing, and paragraph
                            length to name a few. While it's not possible to take into all these factors when estimating
                            how many words per page there will be for your writing, this calculator can give a more
                            accurate words per page conversion estimate than the typical <a
                                href="/blog/2015/09/18/10655_how-many-pages-is-2000-words.html">250/500 ballpark
                                figure</a>.</p>
                        <p>The calculator is able to provide a more accurate conversion by taking into account more
                            specific information. For example, you can choose from a different variety of common fonts
                            to generate an estimate:</p>
                        <ul>
                            <li> Arial</li>
                            <li> Calibri</li>
                            <li> Comic Sans MS</li>
                            <li> Courier</li>
                            <li> Times New Roman</li>
                            <li> Verdana</li>
                        </ul>
                        <p>You can then choose your preferred spacing from the following options:</p>
                        <ul>
                            <li> Single spaced</li>
                            <li> 1.5 spaced</li>
                            <li> Double spaced</li>
                        </ul>
                        <p>Finally, you can choose your preferred font size: 10, 11, 12, 13 or 14.</p>
                        <p>By using these three options to more accurately define your writing, the words per page
                            calculator should provide a better estimate on how many words you need to write to fill a
                            page. In the opposite direction, it can give a more accurate estimate of how many pages you
                            have created if you only know the <a href="/">word count</a>. </p>
                        <p>While we make every attempt to make our calculators as accurate as possible, the results
                            won't be perfect. This converter addresses some issues to provide a more accurate estimate,
                            but in the end, it's still an estimate. Other issues such as margin space and paragraph
                            length will likely result in some variation from the calculations given. That being said, it
                            should provide a more accurate indication of the number of pages a specific word count will
                            be and the number of words per page you type when compared to the general rule of thumb.</p>
                    </div>
                </div>
                <div class="col-sm-6 introduction">
                    <div class="well info_box">
                        <div class="info">How many pages is...?</div>
                        <p>For general information, the following are calculations using 12-point Arial font, double
                            spaced:</p>
                        <p>How many pages is 500 words? 500 words is approximately 1.8 pages.<br>
                            How many pages is 750 words? 750 words is approximately 2.7 pages.<br>
                            How many pages is 1,000 words? 1,000 words is approximately 3.7 pages.<br>
                            How many pages is 1,250 words? 1,250 words is approximately 4.6 pages.<br>
                            How many pages is 1,500 words? 1,500 words is approximately 5.5 pages.<br>
                            How many pages is 2,000 words? 2,000 words is approximately 7.3 pages.<br>
                            How many pages is 2,500 words? 2,500 words is approximately 9.1 pages.<br>
                            How many pages is 3,000 words? 3,000 words is approximately 11 pages.<br>
                            How many pages is 4,000 words? 4,000 words is approximately 14.6 pages.<br>
                            How many pages is 5,000 words? 5,000 words is approximately 18.3 pages.<br>
                            How many pages is 7,500 words? 7,500 words is approximately 27.4 pages.<br>
                            How many pages is 10,000 words? 10,000 words is approximately 36.5 pages.</p>
                    </div>
                    <div class="well info_box">
                        <div class="info">How many words are in pages?</div>
                        <p>How many words are in one page? There are approximately 450 words in one page.<br>
                            How many words are in two pages? There are approximately 900 words in two pages.<br>
                            How many words are in three pages? There are approximately 1350 words in three pages.<br>
                            How many words are in four pages? There are approximately 1800 words in four pages.<br>
                            How many words are in five pages? There are approximately 2250 words in five pages.<br>
                            How many words are in ten pages? There are approximately 4500 words in ten pages.<br>
                            How many words are in 15 pages? There are approximately 6750 words in 15 pages.<br>
                            How many words are in 25 pages? There are approximately 11250 words in 25 pages.<br>
                            How many words are in 50 pages? There are approximately 22500 words in 50 pages.<br>
                            How many words are in 100 pages? There are approximately 45000 words in 100 pages.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <?php include('./footer.php');?>
    <script src="./min/9421d0c24ecaffb4402be6bd959f301bb2c52ebf.js"></script>
    <script src="./js/footer.js"></script>
</body>
</html>