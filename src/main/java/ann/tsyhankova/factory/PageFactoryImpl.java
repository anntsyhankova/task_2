package ann.tsyhankova.factory;

import ann.tsyhankova.pages.DeltaMainPage;
import ann.tsyhankova.pages.MainPage;
import ann.tsyhankova.pages.ResultPage;

public class PageFactoryImpl implements PageFactory{
    @Override
    public MainPage getMainPage() {
        return new DeltaMainPage();
    }

    @Override
    public ResultPage getResultPage() {
//        return new DeltaResultPage();
        return null;
    }
}
