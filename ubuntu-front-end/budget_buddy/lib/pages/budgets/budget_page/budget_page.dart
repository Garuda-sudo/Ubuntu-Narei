import 'package:budget_buddy/pages/budgets/budget_page/budget_summary_list.dart';
import 'package:flutter/material.dart';

class BudgetPage extends StatefulWidget {
  const BudgetPage({super.key});

  @override
  State<BudgetPage> createState() => _BudgetPageState();
}

class _BudgetPageState extends State<BudgetPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body: Column(
        children: [
          Container(
            child: const Text('Total Budget for June'),
          ),
          Container(
            height: 250,
            color: Colors.white,
            child: const Center(child: Text('Budget chart widget goes here')),
          ),
          Expanded(
            child: Container(
                decoration: BoxDecoration(
                    color: Colors.blueGrey.shade800,
                    borderRadius: const BorderRadius.only(
                        topLeft: Radius.circular(25),
                        topRight: Radius.circular(25))),
                child: const BudgetSummaryList()),
          )
        ],
      ),
    );
  }
}
