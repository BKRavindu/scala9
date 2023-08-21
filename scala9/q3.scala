class Account(initialBalance: Double) {
  private var balance: Double = initialBalance
  
  def getBalance: Double = balance
  
  def deposit(amount: Double): Unit = {
    require(amount > 0, "Amount to deposit must be positive")
    balance += amount
  }
  
  def withdraw(amount: Double): Boolean = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      true
    } else {
      false
    }
  }
  
  def transfer(amount: Double, targetAccount: Account): Boolean = {
    if (withdraw(amount)) {
      targetAccount.deposit(amount)
      true
    } else {
      false
    }
  }
}

object Main extends App {
  val account1 = new Account(1000.0)
  val account2 = new Account(500.0)
  
  println(s"Account 1 balance: ${account1.getBalance}")
  println(s"Account 2 balance: ${account2.getBalance}")
  
  account1.deposit(200.0)
  println(s"Account 1 balance after deposit: ${account1.getBalance}")
  
  if (account1.withdraw(300.0)) {
    println("Withdrawal from Account 1 successful")
  } else {
    println("Withdrawal from Account 1 failed")
  }
  
  if (account1.transfer(150.0, account2)) {
    println("Transfer from Account 1 to Account 2 successful")
  } else {
    println("Transfer from Account 1 to Account 2 failed")
  }
  
  println(s"Account 1 balance: ${account1.getBalance}")
  println(s"Account 2 balance: ${account2.getBalance}")
}
