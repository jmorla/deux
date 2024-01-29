package org.deuxc.diagnostic;

import org.deuxc.diagnostic.DxcDiagnostic.Error;

public class DefaultLogger implements Log {


    @Override
    public void error(int pos, Error errorMessage) {}
    
}
