package ann.tsyhankova.factory;

import ann.tsyhankova.pages.MainPage;
import ann.tsyhankova.pages.ResultPage;

public interface PageFactory {

    MainPage getMainPage();

    ResultPage getResultPage();
}
