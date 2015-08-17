package alertme.pojo;

import java.math.BigDecimal;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

@SpaceClass
public class Quote {

	public Quote() {
	}

	private String id;
	private String stockName;
	private BigDecimal closePrice;

	@SpaceId(autoGenerate = true)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public BigDecimal getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(BigDecimal closePrice) {
		this.closePrice = closePrice;
	}
	@Override
	public String toString() {
		return "Quote [id=" + id + ", stockName=" + stockName + ", closePrice=" + closePrice + "]";
	}

}
