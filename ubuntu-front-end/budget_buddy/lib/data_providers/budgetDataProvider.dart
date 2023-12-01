import 'package:budget_buddy/services/budgetService.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

import '../models/budget.dart';

final budgetDataProvider = FutureProvider<List<Budget>>((ref) async {
  return await ref.watch(budgetProvider).getBudgets();
});
