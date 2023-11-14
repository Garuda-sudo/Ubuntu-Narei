import 'dart:ffi';

class Budget {
  final int id;
  final int userId;
  final String name;
  final double amountLimit;
  final DateTime periodType;
  final double budgetTotal;
  //final List<String> members;

  Budget(this.id, this.userId, this.name, this.amountLimit, this.periodType,
      this.budgetTotal);
}
