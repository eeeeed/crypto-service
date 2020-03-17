package com.cryptoserver.service.impl;

import com.cryptoserver.dao.SymbolDao;
import com.cryptoserver.dao.impl.SymbolDaoImpl;
import com.cryptoserver.models.Symbol;
import com.cryptoserver.service.SymbolService;

public class SymbolServiceImpl implements SymbolService {
	
	private SymbolDao symbolDao = null;

	@Override
	public Symbol getSymbol(String symbolName) {
		return getSymbolDao().getSymbol(symbolName);
	}
	
	private SymbolDao getSymbolDao() {
		if (symbolDao == null) {
			symbolDao = new SymbolDaoImpl();
		}
		return symbolDao;
	}

}
