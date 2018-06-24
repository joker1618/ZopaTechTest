package zopa.test;

import com.zopa.model.Lender;
import com.zopa.market.MarketProviderFactory;
import com.zopa.utils.ZopaUtils;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;

import static com.zopa.utils.ZopaUtils.display;

public class Spikes {
	
	final int LOAN_MONTHS = 36;
	@Test
	public void displayLenders() throws IOException, ParseException {
//		MarketProviderFactory lprov = new MarketProviderFactory(Paths.get("C:\\Users\\f.barbano\\IdeaProjects\\interviews\\ZopaTechTest\\zopa_data\\market.csv"));
//		List<Lender> lenderList = lprov.getLenderList();
//		double sumRata = 0d;
//		double sumAmount = 0d;
//		for(Lender lender : lenderList) {
//			double rata = ZopaUtils.computeRate(lender.getAmount(), lender.getRate(), LOAN_MONTHS);
//			sumRata += rata;
//			sumAmount += lender.getAmount();
//			display("%s --> %f - %f", lender.toString(), rata, LOAN_MONTHS*rata);
//		}
//		display("Tot file %f --> %f - %f", sumAmount, sumRata, LOAN_MONTHS*sumRata);
//		display("[%s; %s]", ZopaUtils.formatDouble(sumAmount, 2), ZopaUtils.formatDouble(sumRata, 1));
//
//		double rata = ZopaUtils.computeRate(1000.0, 0.07, LOAN_MONTHS);
//		display("0.07; 1000.0 --> %f - %f", rata, LOAN_MONTHS*rata);
	}


	@Test
	public void misc() {
		BigDecimal a = new BigDecimal("10.12445");
		BigDecimal b = a.setScale(2, BigDecimal.ROUND_HALF_UP);
		System.out.println(b);
		a = a.add(new BigDecimal("0.001"));
		b = a.setScale(2, BigDecimal.ROUND_HALF_UP);
		System.out.println(b);
		System.out.println(b.doubleValue());
		System.out.println(b.add(BigDecimal.valueOf(0.002)));

		System.out.println(new BigDecimal(10.1149).setScale(2, BigDecimal.ROUND_HALF_UP));
		System.out.println(new BigDecimal(10.115).setScale(2, BigDecimal.ROUND_HALF_UP));
		System.out.println(new BigDecimal(10.1149).setScale(2, BigDecimal.ROUND_HALF_EVEN));
		System.out.println(new BigDecimal(10.115).setScale(2, BigDecimal.ROUND_HALF_EVEN));
	}
}
