import 'package:budget_buddy/models/budget.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:http/http.dart';

class BudgetService {
  List<Budget> mockBudgetList = [];

  Future<List<Budget>> getBudgets() async {
    Response response = await get(Uri.parse('spring-boot-backend'));

    if (response.statusCode == 200) {
      //print(response.body.toString());
      var budget1 = Budget(
          id: 1,
          userId: 1234,
          name: "Micky",
          amountLimit: 200.00,
          periodType: DateTime(2023, 11, 18),
          budgetTotal: 1000.00,
          budgetMotto: "To Infinity & Beyond");

      var budget2 = Budget(
          id: 2,
          userId: 1,
          name: "Baba",
          amountLimit: 10000.00,
          periodType: DateTime(2023, 11, 20),
          budgetTotal: 1000000.00,
          budgetMotto: "For a Legacy");

      var budget3 = Budget(
          id: 2,
          userId: 1,
          name: "Mummy",
          amountLimit: 1000.00,
          periodType: DateTime(2023, 11, 21),
          budgetTotal: 100000.00,
          budgetMotto: "For Family");

      mockBudgetList.addAll([budget1, budget2, budget3]);
      return mockBudgetList;
    } else {
      throw Exception(response.reasonPhrase);
    }
  }

  List<Budget> addToBudgets(Budget budget) {
    mockBudgetList.add(budget);
    return mockBudgetList;
  }
}

final budgetProvider = Provider<BudgetService>(
  (ref) => BudgetService(),
);
