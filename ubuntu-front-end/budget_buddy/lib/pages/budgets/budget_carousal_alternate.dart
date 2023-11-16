import 'package:flutter/material.dart';

class BudgetList extends StatefulWidget {
  const BudgetList({super.key});

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
                        height: 70,
                        child: Stack(),
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
