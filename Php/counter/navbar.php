<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse" aria-expanded="false" aria-controls="wc_navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="./" style="padding:5px 25px 5px 15px; background-repeat: no-repeat; background-position:15px;">
                <!--<img class="lazy" data-src="./images/wc-logo.png" style="height:100%" alt="Logo">-->
            </a>
        </div>
        <div class="navbar-collapse collapse" aria-expanded="false" role="menu">
            <ul class="nav navbar-nav" id="wc_navbar">
                <li class="active"><a href="./" data-tr-detail="home">Home</a></li>
                <li><a href="./our-tools" data-tr-detail="our-tools">Tools</a></li>
                <!--<li><a href="#" data-toggle="modal" data-target="#social-login-modal"><span data-tr-detail="sign_in">Sign In</span><i class="fa fa-sign-in" aria-hidden="true" style="font-size: 16px; margin-left: 5px"></i> </a></li>
                <li style="margin-top:14px; margin-left:8px; display:none">
                    <div id="w1">
                        <ul class="auth-clients">
                            <li><a class="twitter auth-link" href="/user/security/auth?authclient=twitter" title="Twitter"><span class="auth-icon twitter"></span></a></li>
                            <li><a class="facebook auth-link" href="/user/security/auth?authclient=facebook" title="Facebook" data-popup-width="860" data-popup-height="480"><span class="auth-icon facebook"></span></a></li>
                            <li><a class="google auth-link" href="/user/security/auth?authclient=google" title="Google"><span class="auth-icon google"></span></a></li>
                        </ul>
                    </div>
                </li>
            </ul>-->
            <!--
            <ul id="wc_navshare" class="nav navbar-nav navbar-right" style="margin-top:15px">
                <li>
                    <div class="fb-like" data-href="..." data-layout="button_count" data-action="like" data-show-faces="false" data-share="false"></div>
                </li>
                <li>
                    <div class="g-plusone" data-size="medium"></div>
                </li>
                <li><a href="https://twitter.com/share" class="twitter-share-button" data-url="..." data-hashtags="wordcount"></a></li>
            </ul>-->
        </div>
    </div>
</div>

<div class="modal fade" id="social-login-modal" tabindex="-1" role="dialog" aria-labelledby="social-login-modal-label" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="social-login-modal-label" data-tr-detail="sign_in">Sign In</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-7"><span data-tr-detail="sign_in_modal_text1">When you sign in to WordCounter you get access to some awesome features.</span><br /><br /><i class="fa fa-floppy-o" style="font-size: 17px"></i>&nbsp;
                        <b data-tr-detail="auto_save_modal">Auto Save</b><br /><small style="color:gray" data-tr-detail="sign_in_modal_text2">We'll save whatever you're working on automatically and even store multiple versions so you can access it in case your browser crashes or you accidentally close your browser.</small><br
                        /><br /><i class="fa fa-trophy" style="font-size: 17px"></i>&nbsp;
                        <b data-tr-detail="writing_goals">Writing Goals</b><br /><small style="color:gray" data-tr-detail="sign_in_modal_text3">Setup writing goals you want to work toward and even embed them in your blog or website.</small><br />
                        <i class="fa fa-shopping-cart" style='margin-top:20px; font-size: 18px'></i>&nbsp;
                            <b data-tr-detail="fewer_advertisements">20% OFF Grammarly Premium</b><br /><small style="color:gray" data-tr-detail="sign_in_modals_text4">Enable unlimited checks for plagiarism and writing issues. Connects seamlessly with your free WordCounter account.</small></div>
                    <div class="col-md-5">
                        <div class="login-form ">
                            <div class="site-login-form">
                                <p data-tr-detail="login_with_your_site_account">Login with your site account:</p>
                                <form id="login-form" class="" action="/user/security/login" method="post"><input type="hidden" name="_csrf" value="YkJRV2hwWkw4MnxlNwEOCTEsAg5RFgkhFDQXZwwAKAIpKRIEIDcqdQ==">
                                    <div class="error-summary alert alert-danger" style="display:none">
                                        <ul></ul>
                                    </div>
                                    <div class="form-group field-loginform-email required">
                                        <div><input type="text" id="loginform-email" class="form-control" name="LoginForm[email]" placeholder="Email" data-tr-detail="email"></div>
                                    </div>
                                    <div class="form-group field-loginform-password required">
                                        <div><input type="password" id="loginform-password" class="form-control" name="LoginForm[password]" placeholder="Password" data-tr-detail="password"></div>
                                    </div>
                                    <div class="form-group"><button type="submit" class="btn btn-primary btn-login" name="login-button" data-tr-detail="login">Login</button>
                                        <div class="text-center" style="margin-top: 8px; font-size: 12px;"><a href="/user/security/request-password-reset" data-link="signupFormLink" style="text-decoration: underline !important;" data-tr-detail="forgot_your_password">Forgot your password?</a> </div>
                                        <div class="text-center"
                                            style="margin-top: 8px; font-size: 12px;"><a href="javascript:void(0);" data-link="signupFormLink" style="text-decoration: underline !important;" data-tr-detail="dont_have_an_account_yet_create_one_now_its_free">Don't have an account yet? Create one now, it's FREE</a>                                                </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="signup-form hidden">
                            <p data-tr-detail="create_a_site_account">Create a site account:</p>
                            <form id="signup-form" class="" action="/site/signup" method="post"><input type="hidden" name="_csrf" value="YkJRV2hwWkw4MnxlNwEOCTEsAg5RFgkhFDQXZwwAKAIpKRIEIDcqdQ==">
                                <div class="error-summary alert alert-danger" style="display:none">
                                    <ul></ul>
                                </div>
                                <div class="form-group field-signupform-email required">
                                    <div><input type="text" id="signupform-email" class="form-control" name="SignupForm[email]" placeholder="Email" data-tr-detail="email"></div>
                                </div>
                                <div class="form-group field-signupform-email_repeat required">
                                    <div><input type="text" id="signupform-email_repeat" class="form-control" name="SignupForm[email_repeat]" placeholder="Re-enter Email" data-tr-detail="re_enter_email"></div>
                                </div>
                                <div class="form-group field-signupform-password required">
                                    <div><input type="password" id="signupform-password" class="form-control" name="SignupForm[password]" placeholder="Password" data-tr-detail="password"></div>
                                </div>
                                <div class="form-group field-signupform-password_repeat required">
                                    <div><input type="password" id="signupform-password_repeat" class="form-control" name="SignupForm[password_repeat]" placeholder="Re-enter Password" data-tr-detail="re_enter_password"></div>
                                </div>
                                <div class="form-group"><button type="submit" class="btn btn-primary btn-login" name="login-button" data-tr-detail="create_account">Create Account</button>
                                    <div class="text-center" style="margin-top: 8px; font-size: 12px;"><a href="javascript:void(0);" data-tr-detail="already_have_an_account_login" data-link="loginFormLink" style="text-decoration: underline !important;">Already have an account? Login</a><br /><a href="/user/security/request-password-reset" style="text-decoration: underline !important;">Forgot your password (or want to change it)?</a></div>
                                </div>
                            </form>
                        </div>
                </div>
            </div>
        </div>
        <div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal" data-tr-detail="close">Close</button></div>
        </div>
    </div>
</div>