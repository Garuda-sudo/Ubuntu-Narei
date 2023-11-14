import 'package:flutter/material.dart';

class NewsFeedBudgetCard extends StatefulWidget {
  const NewsFeedBudgetCard({super.key});

  @override
  State<NewsFeedBudgetCard> createState() => _NewsFeedBudgetCardState();
}

class _NewsFeedBudgetCardState extends State<NewsFeedBudgetCard> {
  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.only(top: 8.0, bottom: 15.0),
      child: Container(
        decoration: BoxDecoration(
            borderRadius: BorderRadius.circular(8.0), color: Colors.amber[100]),
        child: Column(
          children: [
            Text('Budget Name'),
            Text('Budget Description'),
            Text('Budget Total Value'),
          ],
        ),
      ),
    );
  }
}
