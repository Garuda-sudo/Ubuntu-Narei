import 'package:budget_buddy/budgets/budget_page/budget_summary_list.dart';
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
            height: 50,
            color: Colors.green,
          ),
          Container(
            height: 300,
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
      bottomNavigationBar: BottomNavigationBar(
        // currentIndex: currentTab,
        // onTap: (value) {
        //   setState(() {
        //     currentTab = value;
        //   });
        // },
        items: const <BottomNavigationBarItem>[
          BottomNavigationBarItem(
            icon: Icon(Icons.home),
            label: 'Home',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.person),
            label: 'Profile',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.newspaper),
            label: 'Financial News',
          )
        ],
      ),
    );
  }
}
