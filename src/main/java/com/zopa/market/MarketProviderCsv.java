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

class MarketProviderCsv implements MarketProvider {

	private static final String HEADER_MARKET_FILE = "Lender,Rate,Available";

	private Path lenderFilePath;
	private List<Lender> lenderList;

	public MarketProviderCsv(Path lenderFilePath) throws IOException, MarketException {
		this.lenderFilePath = lenderFilePath;
		this.lenderList = readLendersFromCsv(lenderFilePath);
	}

	@Override
	public List<Lender> getLenderList() {
		return lenderList;
	}

	private List<Lender> readLendersFromCsv(Path csvPath) throws IOException, MarketException {
		List<Lender> lenders = new ArrayList<>();
		for(String line : Files.readAllLines(csvPath)) {
			if(StringUtils.isNotBlank(line) && !HEADER_MARKET_FILE.equalsIgnoreCase(line)) {
				// review remove # check
				if(!line.trim().startsWith("#"))	lenders.add(parseLender(line));
//				lenders.add(parseLender(line));
			}
		}
		return lenders;
	}

	private Lender parseLender(String line) throws MarketException {
		try {
			String[] split = line.split(",");
			double rate = ZopaUtils.parseDouble(split[1]);
			double amount = ZopaUtils.parseDouble(split[2]);
			return new Lender(split[0], rate, amount);

		} catch (Exception ex) {
			throw new MarketException(ex);
		}
	}
}
