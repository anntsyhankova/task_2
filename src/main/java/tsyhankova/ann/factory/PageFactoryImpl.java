package tsyhankova.ann.factory;

import tsyhankova.ann.pages.DeltaMainPage;
import tsyhankova.ann.pages.DeltaResultPage;

public class PageFactoryImpl implements PageFactory{
    @Override
    public DeltaMainPage getMainPage() {
        return new DeltaMainPage();
    }

    @Override
    public DeltaResultPage getResultPage() {
//        return new DeltaResultPage();
        return null;
    }
}
