package org.vermeg.bookstore.mapping;

import java.util.Date;
import java.util.List;

import org.vermeg.bookstore.model.CommandLine;


public class InvoiceResponse {

	
	
	
    private Long id;
	private Date dateInvoice;
	private List<CommandLine> commandline;
	private double TotalPriceInvoice;
	 
	 
	public InvoiceResponse(Long id, Date dateInvoice, List<CommandLine> commandline, double totalPriceInvoice) {
		super();
		this.id = id;
		this.dateInvoice = dateInvoice;
		this.commandline = commandline;
		TotalPriceInvoice = totalPriceInvoice;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDateInvoice() {
		return dateInvoice;
	}


	public void setDateInvoice(Date dateInvoice) {
		this.dateInvoice = dateInvoice;
	}


	public List<CommandLine> getCommandline() {
		return commandline;
	}


	public void setCommandline(List<CommandLine> commandline) {
		this.commandline = commandline;
	}


	public double getTotalPriceInvoice() {
		return TotalPriceInvoice;
	}


	public void setTotalPriceInvoice(double totalPriceInvoice) {
		TotalPriceInvoice = totalPriceInvoice;
	}
	 
	 
	 
	 
	 
}
