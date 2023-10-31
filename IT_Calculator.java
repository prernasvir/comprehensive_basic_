import java.util.Scanner;

public class IT_Calculator {
    public static void main(String[] args) {
        double TaxableIncome, TaxPaidPerYear, TaxPayablePerMonth;

        // Create a Scanner object to read TaxableIncome from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter TaxableIncome
        System.out.print("Enter your Taxable Income: $");
        TaxableIncome = scanner.nextDouble();

        // Calculate tax based on income range
        if (TaxableIncome <= 25000) {
            TaxPaidPerYear = 0;
        } else if (TaxableIncome <= 50000) {
            TaxPaidPerYear = (TaxableIncome - 25000) * 0.10;
        } else if (TaxableIncome <= 75000) {
            TaxPaidPerYear = (25000 * 0.10) + ((TaxableIncome - 50000) * 0.20);
        } else {
            TaxPaidPerYear = (25000 * 0.10) + (25000 * 0.20) + ((TaxableIncome - 75000) * 0.30);
        }

        // Calculate monthly tax payment
        TaxPayablePerMonth = TaxPaidPerYear / 12;

        // Display the results
        System.out.println("Tax Paid in a Year: $" + TaxPaidPerYear);
        System.out.println("Tax Payable in a Month: $" + TaxPayablePerMonth);

        // Close the scanner
        scanner.close();
    }
}
