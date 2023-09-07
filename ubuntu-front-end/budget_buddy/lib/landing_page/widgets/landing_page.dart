import 'package:budget_buddy/accounts/account_card.dart';
import 'package:budget_buddy/accounts/accounts_carousal.dart';
import 'package:budget_buddy/budgets/budget_card.dart';
import 'package:budget_buddy/budgets/budget_carousal.dart';
import 'package:budget_buddy/landing_page/widgets/landing_page_graph_component.dart';
import 'package:flutter/material.dart';

class LandingPage extends StatefulWidget {
  const LandingPage({super.key});

  @override
  State<LandingPage> createState() => _LandingPageState();
}

class _LandingPageState extends State<LandingPage> {
  @override
  Widget build(BuildContext context) {
    return const Column(
      mainAxisAlignment: MainAxisAlignment.start,
      crossAxisAlignment: CrossAxisAlignment.stretch,
      children: [
        SizedBox(
          height: 5.0,
        ),
        LandingPageGraphComponent(),
        Row(
          mainAxisAlignment: MainAxisAlignment.start,
          children: [
            Text("My Budgets"),
          ],
        ),
        BudgetCarousal(),
        AccountCarousal()
      ],
    );
  }
}
