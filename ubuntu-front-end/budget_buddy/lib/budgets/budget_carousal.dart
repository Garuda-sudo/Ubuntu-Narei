import 'package:budget_buddy/budgets/budget_card.dart';
import 'package:budget_buddy/budgets/budget_page/budget_page.dart';
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
          height: 200,
          color: Colors.white,
          child: Padding(
            padding: const EdgeInsets.all(8.0),
            child: Container(
              decoration: const BoxDecoration(
                color: Colors.white,
                borderRadius: BorderRadius.all(Radius.circular(20)),
                boxShadow: [
                  BoxShadow(
                      color: Colors.grey,
                      offset: Offset(2, 2),
                      spreadRadius: 2,
                      blurRadius: 7)
                ],
              ),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  const SizedBox(
                    height: 20,
                  ),
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Container(
                      height: 120,
                      color: Colors.white,
                      child: ListView.builder(
                          scrollDirection: Axis.horizontal,
                          itemCount: 5,
                          itemBuilder: (BuildContext context, int index) {
                            return GestureDetector(
                              onTap: () {
                                Navigator.push(
                                    context,
                                    MaterialPageRoute(
                                        builder: (_) => const BudgetPage()));
                              },
                              child: const BudgetCard(),
                            );
                          }),
                    ),
                  ),
                  const Center(
                    child: Icon(Icons.more_horiz),
                  )
                ],
              ),
            ),
          ),
        )
      ],
    );
  }
}
