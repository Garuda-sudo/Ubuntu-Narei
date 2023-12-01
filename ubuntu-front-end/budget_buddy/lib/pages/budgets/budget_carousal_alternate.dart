import 'package:flutter/material.dart';

import '../../models/budget.dart';

class BudgetList extends StatefulWidget {
  final List<Budget> budgetList;

  const BudgetList({super.key, required this.budgetList});

  @override
  State<BudgetList> createState() => _BudgetListState();
}

class _BudgetListState extends State<BudgetList> {
  PageController pageController =
      PageController(viewportFraction: 0.5, initialPage: 1);

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        SizedBox(
          height: 280,
          child: PageView.builder(
              itemCount: widget.budgetList.length,
              controller: pageController,
              itemBuilder: (context, index) {
                return Container(
                  margin:
                      const EdgeInsets.symmetric(vertical: 32, horizontal: 17),
                  decoration: BoxDecoration(
                      color: Colors.white,
                      borderRadius: BorderRadius.circular(17),
                      boxShadow: [
                        BoxShadow(
                            blurRadius: 8,
                            color: Colors.black.withOpacity(0.5),
                            offset: const Offset(0, 7)),
                      ]),
                  child: Column(
                    children: [
                      Container(
                        //color: Colors.amber,
                        height: 100,
                        child: Column(
                          children: [
                            Padding(
                              padding: const EdgeInsets.all(8.0),
                              child: Text(
                                widget.budgetList[index].name,
                                style: const TextStyle(
                                    fontSize: 20,
                                    fontWeight: FontWeight.bold,
                                    letterSpacing: 1.2),
                              ),
                            ),
                            Text(
                              widget.budgetList[index].budgetMotto,
                              style: const TextStyle(
                                  fontSize: 10, letterSpacing: 1.2),
                            ),
                            Padding(
                              padding: const EdgeInsets.all(8.0),
                              child: Container(
                                height: 15,
                                width: MediaQuery.of(context).size.width * 0.8,
                                decoration: BoxDecoration(
                                    color: Colors.indigo[300],
                                    borderRadius: BorderRadius.circular(5)),
                              ),
                            )
                          ],
                        ),
                      ),
                      Container()
                    ],
                  ),
                );
              }),
        ),
      ],
    );
  }
}
