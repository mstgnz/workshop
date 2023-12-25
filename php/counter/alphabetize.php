<!DOCTYPE html>
<html lang="en-US">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="sa_site" content="1" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Alphabetize Your Lists</title>
    <meta name="description"
        content="Alphabetize list is a free online tool which will put any list you have into alphabetical order." />
    <meta name="keywords" content="alphabetize, alphabitze list, alphabetical order, number list, delete duplicate entries" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="apple-touch-icon" sizes="180x180" href="/images/apple-touch-icon.png" />
    <meta name="msapplication-TileColor" content="#202020" />
    <meta name="msapplication-TileImage" content="/images/icon-144.png" />
    <link rel="stylesheet" type="text/css" href="./css/style.css" />
    <link href="./min/f2f47b3e38e1db08f29d702d29756b9f4bb6decf.css" rel="stylesheet" />
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
            <h1 class="teeshirt-page-title text-uppercase"> Alphabetize Tool </h1>
            <div class="row">
                <div class="col-md-4" style="margin-bottom: 15px">
                    <div class="well tools_header">
                        List Options
                    </div>
                    <div class="col-md-12" id="sorting_tools">
                        <div class="mb10">
                            <button class="btn btn-primary" name="options_radios" id="sort_alphabetize"
                                onclick="alphabetize();">Alphabetize</button>
                            <a href="#sort_alphabetize_h4"><span class="glyphicon glyphicon-question-sign"></span></a>
                        </div>
                        <div class="mb10">
                            <button class="btn btn-primary" name="options_radios" id="alphabetize_categorized_list"
                                onclick="alphabetizeCatList();">Alphabetize Categorized List</button>
                            <a href="#alphabetize_categorized_list_h4"><span
                                    class="glyphicon glyphicon-question-sign"></span></a>
                        </div>
                        <div class="mb10">
                            <button class="btn btn-primary" name="options_radios" id="sort_by_last_name"
                                onclick="sortByLastName();">Alphabetize by Last Name</button>
                            <a href="#sort_by_last_name_h4"><span class="glyphicon glyphicon-question-sign"></span></a>
                        </div>
                        <div class="mb10">
                            <button class="btn btn-primary" name="options_radios" id="remove_duplicate"
                                onclick="removeDuplicates();">Remove List Duplicates</button>
                            <a href="#remove_duplicate_h4"><span class="glyphicon glyphicon-question-sign"></span></a>
                        </div>
                        <div class="mb10">
                            <button class="btn btn-primary" name="options_radios" id="reverse_list"
                                onclick="reverseList();">Reverse List</button>
                            <a href="#reverse_list_h4"><span class="glyphicon glyphicon-question-sign"></span></a>
                        </div>
                        <div class="mb10">
                            <button class="btn btn-primary" name="options_radios" id="randomize_sort"
                                onclick="randomize();">Randomize List</button>
                            <a href="#randomize_sort_h4"><span class="glyphicon glyphicon-question-sign"></span></a>
                        </div>
                        <div class="mb10">
                            <button class="btn btn-primary" name="options_radios" id="add_li_tag"
                                onclick="addLiTagToEachItem();">Add < li> tags</button>
                            <a href="#add_li_tag_h4"><span class="glyphicon glyphicon-question-sign"></span></a>
                        </div>
                        <div class="mb10">
                            <button class="btn btn-primary" name="options_radios" id="remove_html"
                                onclick="removeHtml();">Remove HTML</button>
                            <a href="#remove_html_h4"><span class="glyphicon glyphicon-question-sign"></span></a>
                        </div>
                        <div class="mb10">
                            <button class="btn btn-primary" name="options_radios" id="numbering"
                                onclick="numbering();">Add Numbers / Letters</button>
                            <a style="margin-left: 5px" role="button" data-toggle="collapse" href="#collapseNumbering"
                                aria-expanded="false" aria-controls="collapseNumbering">
                                <i class="fa fa-wrench" style="line-height:1.1"></i> </a>
                            <a href="#numbering_h4"><span class="glyphicon glyphicon-question-sign"></span></a>
                            <div class="collapse" id="collapseNumbering">
                                <div class="well">
                                    <select name="labelType" class="form-control input-sm" id="select_numbering">
                                        <option value="number">Numbers</option>
                                        <option value="roman"> Roman Numerals</option>
                                        <option value="capital_letter">Capital Letters</option>
                                        <option value="small_letter">Small Letters</option>
                                    </select>
                                    <span>separate with</span>
                                    <input name="label_separator" value="." class="form-control input-sm mt10"
                                        id="label_separator" type="text" maxlength="15">
                                </div>
                            </div>
                        </div>
                        <div class="mb10">
                            <button class="btn btn-primary" name="options_radios" id="add_to_term"
                                onclick="addTextToEachItem();">Add Custom Text</button>
                            <a style="margin-left: 5px" role="button" data-toggle="collapse" href="#collapseAddToTerm"
                                aria-expanded="false" aria-controls="collapseAddToTerm">
                                <i class="fa fa-wrench" style="line-height:1.1"></i> </a>
                            <a href="#add_to_term_h4"><span class="glyphicon glyphicon-question-sign"></span></a>
                            <div class="collapse" id="collapseAddToTerm">
                                <div class="well">
                                    <span>Add</span>
                                    <input name="add_to" type="text" class="form-control input-sm" id="add_to">
                                    <span>to the</span>
                                    <select name="add_to_where" class="form-control input-sm mt10" id="add_to_where">
                                        <option value="start">Beginning</option>
                                        <option value="end">End</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="mb10">
                            <button class="btn btn-primary" name="options_radios" id="change_list_type"
                                onclick="changeListType();">Change List Type</button>
                            <a style="margin-left: 5px" role="button" data-toggle="collapse" href="#collapseListType"
                                aria-expanded="false" aria-controls="collapseListType">
                                <i class="fa fa-wrench" style="line-height:1.1"></i> </a>
                            <a href="#change_list_type_h4"><span class="glyphicon glyphicon-question-sign"></span></a>
                            <div class="collapse" id="collapseListType">
                                <div class="well">
                                    <select class="form-control input-sm" id="select_list_type">
                                        <option value="new_line">New Line</option>
                                        <option value="comma">Comma</option>
                                        <option value="space">Space</option>
                                        <option value="custom">Custom</option>
                                    </select>
                                    <span style="display: none">enter separator
                                        <input name="custom_separator" class="form-control input-sm"
                                            id="custom_separator" type="text" maxlength="15">
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div>
                            <input type="checkbox" name="ignore_word" id="ignore_word">
                            <label for="ignore_word">Ignore</label>
                            <select name="ignore_which_word" class="form-control input-sm" id="ignore_which_word">
                                <option value="1">1st</option>
                                <option value="2">1st &amp; 2nd</option>
                                <option value="3">1st, 2nd &amp; 3rd</option>
                                <option value="4">1st ,2nd ,3rd ,4th</option>
                            </select>
                            <label>word(s) when sorting.</label>
                            <a href="#ignore_word_h4"><span class="glyphicon glyphicon-question-sign"></span></a>
                        </div>
                        <div>
                            <input type="checkbox" name="sort_ignore_definite" id="sort_ignore_definite">
                            <label for="sort_ignore_definite">Ignore Definite Articles</label>
                            <a href="#ignore_word_h4"><span class="glyphicon glyphicon-question-sign"></span></a>
                        </div>
                        <div class="mb10">
                            <input type="checkbox" name="sort_ignore_indefinite" id="sort_ignore_indefinite">
                            <label for="sort_ignore_indefinite">Ignore Indefinite Articles</label>
                            <a href="#ignore_word_h4"><span class="glyphicon glyphicon-question-sign"></span></a>
                        </div>
                    </div>
                </div>
                <div class="col-md-8" style="padding-right: 0">
                    <div class="keywordsBox">
                        <div class="col-md-12 well" style="margin-bottom: 0; padding: 0">
                            <div class="col-md-5 tools_header">
                                Input List Below
                            </div>
                            <div id="separate_terms_with" class="col-md-7">
                                <label>How is your list formatted? </label>
                                <div>
                                    <input type="radio" name="term_delimiter" value="new_line"
                                        title="Separate with a New Line" id="delimiter_new_line"
                                        checked="checked"><label for="delimiter_new_line">New Line</label>
                                    <input type="radio" name="term_delimiter" value="comma"
                                        title="Separate with a Comma" id="delimiter_comma"><label
                                        for="delimiter_comma">Comma</label>
                                    <input type="radio" name="term_delimiter" value="space" title="Separate with a Tab"
                                        id="delimiter_tab"><label for="delimiter_tab">Space</label>
                                    <input type="radio" name="term_delimiter" value="custom"
                                        title="Separate with a Custom Character" id="term_delimiter_custom_radio"><label
                                        for="term_delimiter_custom_radio">Custom</label>
                                    <input type="text" name="term_delimiter_custom" class="form-control input-sm"
                                        id="term_delimiter_custom" maxlength="10" disabled>
                                </div>
                            </div>
                        </div>
                        <textarea class="form-control table-data" id="alphabetize_textarea"
                            placeholder="Enter your list of items below to put them in alphabetical order."
                            rows=12></textarea>
                        <div class="well" style="margin-top: 0">
                            <button class="btn btn-default" id="reset_button">Reset</button>
                            <button class="btn btn-default" id="copy_button">Copy to Clipboard</button>
                            <button class="btn btn-default" id="print_button">Print</button>
                        </div>
                    </div>
                </div>
                <div class="col-md-12" style="padding-right: 0">
                    <div class="well alphabetize_content">
                        <p>It's never fun to think about all the work it's going to take when you have a long list you
                            need to alphabetize. The good news is you can now alphabetize your list (in a variety of
                            ways) in just a few seconds with the Alphabetize Tool.</p>
                        <p><b>Step 1:</b> Choose the type of list you have: a new line for each list item, a comma in
                            between each list item or a space between each list item.</p>
                        <p><b>Step 2:</b> Input your list into the text area.</p>
                        <p><b>Step 3:</b> Choose the appropriate button on the left side for the type of alphabetizing
                            function you want to have performed on your list.</p>
                        <p>That's all there is to it. You will have your list alphabetized within seconds saving your
                            time and headaches. Below are some of the tool's feature options that are available:</p>
                        <h4 id="sort_alphabetize_h4">Alphabetize</h4>
                        <p>It does exactly what it says it will do -- put your list into alphabetical order.</p>
                        <h4 id="alphabetize_categorized_list_h4">Alphabetize Categorized List</h4>
                        <p>If you have several lists under different categories, you don't have to input each list
                            separately to alphabetize each of them. You can follow the directions to mark each category
                            and the tool will separately alphabetize the information under each category for your
                            convenience.</p>
                        <h4 id="sort_by_last_name_h4">Alphabetize by Last Name</h4>
                        <p>If you have a list of names you need to have arranged in alphabetical order, you probably
                            don't want that done by the first name. This option will arrange so the new list is
                            alphabetized by the last name without you having to put the last name first.</p>
                        <h4 id="remove_duplicate_h4">Remove List Duplicates</h4>
                        <p>It's common for lists to accidentally have the same information input twice. For example, if
                            you have a long email list, you may be worried your list may have duplicate emails, and you
                            don't want to send the same information out twice. Using this button will make sure that any
                            duplicate content within the list will be removed.</p>
                        <h4 id="reverse_list_h4">Reverse List</h4>
                        <p>There may be a time when you want your list to be alphabetized from "z to a" instead of from
                            a to z. Choosing this button will give you a reverse alphabetized list.</p>
                        <h4 id="randomize_sort_h4">Randomize List</h4>
                        <p>Sometimes you want to change the order of the list you have, but don't want it to be in a
                            specific order. The randomize button will do this for you.</p>
                        <h4 id="add_li_tag_h4">Add < li> tags</h4>
                        <p>If you are making a list for a blog post or to post online, you may want bullet points in
                            front of each item on the list. Pressing this button will place the HTML tags on your list
                            so it will show up as bullet points in your article.</p>
                        <h4 id="remove_html_h4">Remove HTML</h4>
                        <p>If you have a list that happens to include HTML tags as part of it, you can use the Remove
                            HTML button to strip all of the HTML tags from the list. This will allow the list to be
                            properly alphabetized.</p>
                        <h4 id="numbering_h4">Add Numbers / Letters</h4>
                        <p>Once you have your list in the order that best fits your needs, you may want to add numbers,
                            letters or some other preface to it. If this is the case, you can press this button and it
                            will automatically number your entire list. If you want Roman numerals, capital letters, or
                            small letters, you can click the wrench to choose one of these or customize to your liking.
                        </p>
                        <h4 id="add_to_term_h4">Add Custom Text</h4>
                        <p>If you need to add something to each entry on your list, this can take a significant amount
                            of time, especially if the list happens to be long. Using the "Add Custom Text" button will
                            allow you to add anything you want to each entry on the list. Clicking on the wrench will
                            let you add the custom text and you can decide it you want it added to the beginning or end
                            of each item on the list.</p>
                        <h4 id="change_list_type_h4">Change List Type</h4>
                        <p>When you input your list, you need to choose how it's formatted at the top of the tool. If
                            you want to change the format of your current list to a different format, you can click on
                            the "Change List Type" button. The default is a "New Line" list, but you can click on the
                            wrench to change your current list to comma, space or your own custom list.</p>
                        <h4 id="ignore_word_h4">Ignore List Options</h4>
                        <p>The bottom three check boxes allow you to ignore certain things when alphabetizing your list.
                            For example, you may want to ignore definite and indefinite articles (or both) when
                            alphabetizing the list. Check these boxes and they will be ignored. You can also choose to
                            ignore certain word placement in the list when alphabetizing.</p>
                        <p>We hope you find this tool useful in formatting your lists to the way you want with minimal
                            effort. We would love to hear what you think of this tool and if you have any suggestions to
                            make it better. If you do, please use the "Contact Us" button at the top of the page.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <?php include('./footer.php');?>
    <script src="./min/01a4f0e7e39402ca7db2bc61a07f545c0d72dcf1.js"></script>
    <script src="./js/footer.js"></script>
    
</body>
</html>