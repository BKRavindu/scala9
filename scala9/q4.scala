class Account_balance(initialBalance: Double) {
  private var balance: Double = initialBalance
  
  // Other methods (deposit, withdraw, transfer) are same as before
  
  def applyInterest(): Unit = {
    if (balance > 0) {
      balance += balance * 0.05 // Deposit interest
    } else {
      balance += balance * 0.1 // Overdraft interest
    }
  }
  
  def getBalance: Double = balance
}

class Bank(accounts: List[Account_balance]) {
  def getAccountsWithNegativeBalance: List[Account_balance] = {
    accounts.filter(account => account.getBalance < 0)
  }
  
  def getTotalBalance: Double = {
    accounts.map(_.getBalance).sum
  }
  
  def applyInterestToAllAccounts(): Unit = {
    accounts.foreach(_.applyInterest())
  }
}

object Main extends App {
  val account1 = new Account_balance(100.0)
  val account2 = new Account_balance(-200.0)
  val account3 = new Account_balance(500.0)
  
  val bank = new Bank(List(account1, account2, account3))
  
  println("Accounts with negative balances:")
  bank.getAccountsWithNegativeBalance.foreach(account => println(s"Account balance: ${account.getBalance}"))
  
  println(s"Total balance of all accounts: ${bank.getTotalBalance}")
  
  bank.applyInterestToAllAccounts()
  
  println("Balances after applying interest:")
  bank.getAccountsWithNegativeBalance.foreach(account => println(s"Account balance: ${account.getBalance}"))
}
