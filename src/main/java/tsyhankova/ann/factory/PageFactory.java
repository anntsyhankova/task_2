package tsyhankova.ann.factory;

import tsyhankova.ann.pages.DeltaMainPage;
import tsyhankova.ann.pages.DeltaResultPage;

public interface PageFactory {

    DeltaMainPage getMainPage();

    DeltaResultPage getResultPage();
}
