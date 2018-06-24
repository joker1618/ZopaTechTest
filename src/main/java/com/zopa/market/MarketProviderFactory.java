package com.zopa.market;

import com.zopa.exceptions.MarketException;
import com.zopa.model.Lender;
import com.zopa.utils.ZopaUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class MarketProviderFactory {

	public static MarketProvider getMarketProvider(Path csvMarketPath) throws IOException, MarketException {
		return new MarketProviderCsv(csvMarketPath);
	}
}
