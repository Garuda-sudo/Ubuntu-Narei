class Budget {
  int id;
  int userId;
  String name;
  double amountLimit;
  DateTime periodType;
  double budgetTotal;
  String budgetMotto;
  //final List<String> members;

  // Budget(this.id, this.userId, this.name, this.amountLimit, this.periodType,
  //     this.budgetTotal);

  Budget(
      {required this.userId,
      required this.id,
      required this.name,
      required this.amountLimit,
      required this.periodType,
      required this.budgetTotal,
      required this.budgetMotto});

  factory Budget.fromJson(Map<String, dynamic> json) {
    return Budget(
        id: json['id'] as int,
        userId: json['userId'] as int,
        name: json['name'] as String,
        amountLimit: json['amountLimit'] as double,
        periodType: json['periodType'] as DateTime,
        budgetTotal: json['budgetTotal'] as double,
        budgetMotto: json['budgetMotto'] as String);
  }

  @override
  String toString() {
    return "Budget object name is: $name";
  }
}
