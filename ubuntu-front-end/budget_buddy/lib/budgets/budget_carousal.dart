import 'package:budget_buddy/budgets/budget_card.dart';
import 'package:flutter/material.dart';

class BudgetCarousal extends StatefulWidget {
  const BudgetCarousal({super.key});

  @override
  State<BudgetCarousal> createState() => _BudgetCarousalState();
}

class _BudgetCarousalState extends State<BudgetCarousal> {
  @override
  Widget build(BuildContext context) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Container(
          padding: const EdgeInsets.all(2.0),
          height: 150,
          color: Colors.white,
          child: ListView.builder(
              scrollDirection: Axis.horizontal,
              itemCount: 5,
              itemBuilder: (BuildContext context, int index) {
                return const BudgetCard();
              }),
        )
      ],
    );
  }
}
