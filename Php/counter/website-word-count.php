<!DOCTYPE html>
<html lang="en-US">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="sa_site" content="1" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Website Page Word Counter</title>
    <meta name="description" content="Website Word Count is a free online tool that counts the words on any website page and gives the top keywords. Simply type in the url." />
    <meta name="keywords" content="website word counter, website page counter, words on a website" />
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
            <h1 class="teeshirt-page-title text-uppercase"> WEB PAGE WORD COUNTER </h1>
            <form action="" method="POST">
                <div class="col-lg-8 col-md-9 col-sm-10 col-xs-12 box-center form-group">
                    <div class="col-sm-10 col-xs-12 teeshirtPage">
                        <input type="text" id="url" name="url"
                            placeholder="Enter the URL of the webpage you want counted" class="form-control" required>
                    </div>
                    <div class="col-sm-2 col-xs-12 teeshirtPage">
                        <input type="submit" name="submit" value="Count Words" class="btn btn-info">
                    </div>
                </div>
            </form>
            <div class="col-sm-8 col-xs-12 box-center keywordsBox">
                <div class="col-sm-6 col-xs-12 form-group">
                    <h3>Non-Common Keywords</h3>
                    <div class="table-data">
                        <table class="table duplicated-keywords">
                            <thead>
                                <tr>
                                    <th>Keyword</th>
                                    <th>Quantity</th>
                                </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col-sm-6 col-xs-12 form-group">
                    <h3>All Keywords</h3>
                    <div class="table-data">
                        <table class="table duplicated-keywords">
                            <thead>
                                <tr>
                                    <th>Keyword</th>
                                    <th>Quantity</th>
                                </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div style="clear:both"></div>
            <div class="well" style="margin-top:20px">
                <p>There may be certain times when instead of wanting to know the word count of your own writing, you'd
                    like to know a website's word count. That is, you'd like to know the word count for a website
                    without having to actually count all the words on the page by hand. Website Word Count is a tool
                    which will do exactly that for you. It's a website word counter created specifically so you can find
                    out the number of words on any page on the Internet. All you need to know is the URL of a web page,
                    place it into the tool, and you can find out exactly how many words are on that page by hitting the
                    "count" button. The tool will count the words on the website's page and instantly provide that
                    number to you.</p>
                <p>Even better, this website word counter will also provide you with a list of the keywords used on the
                    page you request. Not only will you know how many word are written on the page, you'll also know the
                    most common words used on the page. The keyword density list is broken down into two parts. On the
                    left, the tool displays a list of the most common words used on the page entered. The list on the
                    right documents the keyword density of the page excluding all commonly used words (this gives a
                    better indication of what the main topic of the page happens to be, and the keywords used for that
                    topic).</p>
                <p>There are a number of ways this information might be valuable. Translators often want to know the
                    number of words on a web page because it's common for them to charge clients by the number of words
                    on the page they are translating, and not necessarily the number of words they write in the
                    translated language or by the time they spend on it. For this reason, being able to quickly
                    determine the word count of a page is important.</p>
                <p>A reader may simply be curious to know how many words are on the pages of certain writers or bloggers
                    they follow. A writer may also covet this information if they want to style their writing after
                    another blogger or writer they admire. This information may be able to help them better build a
                    website or blog they desire.</p>
                <p>This tool can also be used to check the pages of your own website or blog. When you know which pages
                    are the most popular on your own site, you can enter their URLs to see what number of words seems to
                    perform best with the topics you write about. This can help you write content in the future that
                    also brings more readers to see your writing.</p>
                <p>It can also be of great help for those who write articles for websites and bloggers. For example, for
                    those interested in SEO, they will be able to see the word count and keyword density for popular
                    pages on the Internet on any topic about which they may be writing. This information can give them
                    hints on how to better rank their own writing on that particular topic.</p>
                <p>No matter the reason you decide to use this counter, it should provide you with valuable information
                    you can use to better your writing in addition to the overall content for the blogs and websites for
                    which you write. We are always looking to improve the counters we provide. If you have suggestions
                    you feel would make this tool better, please use the "contact us" link at the top of this page to
                    give us your suggestions.</p>
            </div>
        </div>
    </div>
    
    <?php include('./footer.php');?>
    <script src="./min/9eb2e76ec9e05765cf687e96f02b04d55854e042.js"></script>
    <script src="./js/footer.js"></script>
</body>
</html>