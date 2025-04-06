package com.mycompany.myCompanyEmployee.service;

import org.springframework.stereotype.Service;

@Service
public class TaxCalculationService {
	// Method to calculate tax deduction for an employee based on their salary
		public double calculateTax(double monthltSalary) {

			double yearlySalary = (monthltSalary *12);
		double taxAmount = 0;
		double taxAmountTotal = 0;

		// Tax slabs
		double slab1 = 250000; // First slab: 0% tax
		double slab2 = 500000; // Second slab: 5% tax
		double slab3 = 1000000; // Third slab: 10% tax and morethan slab3 slab: 20%
		// Cess = 2% of ₹Tax Amount


		// Calculate tax for each slab
		if (yearlySalary <= slab1) {
			// No tax
			taxAmountTotal = 0;
		} else if (yearlySalary > slab1 && yearlySalary <= slab2) {
			// 5% tax on slab2
			taxAmount = (yearlySalary - slab1) * 0.05;
			taxAmountTotal = (taxAmount);
		} else if (yearlySalary > slab2 && yearlySalary <= slab3) {
			// 5% tax on slab2, 10% tax on remaining amount
			taxAmount = (slab2 - slab1) * 0.05 + (yearlySalary - slab2) * 0.10;
			taxAmountTotal = calculateCess(taxAmount);
		} else {
			// 5% tax on slab2, 20% tax on slab3, 30% tax on remaining amount
			taxAmount = (slab2 - slab1) * 0.05 + (slab3 - slab2) * 0.10 + (yearlySalary - slab3) * 0.20;
			taxAmountTotal = calculateCess(taxAmount);
		}

		//System.out.println("\n Monthlt Salary: ₹ "+monthltSalary+" and Tax amount for a yearly Salary : ₹ "+yearlySalary+": " + "and Tax amount is: ₹ "+ taxAmountTotal);
		
		return taxAmountTotal;

	}

	// Method to calculate cess amount
	public double calculateCess(double taxAmount) {
		double cess = 0;
		double taxAmountTotal;
		cess = taxAmount * 0.02;
		taxAmountTotal = taxAmount + cess;
		//System.out.println("    Cess(2% of ₹Tax Amount):"+cess+" TaxAmount: ₹"+taxAmount+" TaxAmountTotal( TaxAmount+Cess): ₹"+taxAmountTotal+"\n");

		return taxAmountTotal;
	}

	public double calculateCessValueOnly(double taxAmount) {
		double cess = 0;
		cess = taxAmount * 0.02;

		return cess;
	}

	
}