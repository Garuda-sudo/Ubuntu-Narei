import 'package:flutter/material.dart';

class BudgetSummaryList extends StatefulWidget {
  const BudgetSummaryList({super.key});

  @override
  State<BudgetSummaryList> createState() => _BudgetSummaryListState();
}

class _BudgetSummaryListState extends State<BudgetSummaryList> {
  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Padding(
          padding: const EdgeInsets.all(20.0),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              TextButton(
                style: TextButton.styleFrom(
                  minimumSize: const Size(95, 36),
                  padding: const EdgeInsets.symmetric(horizontal: 10),
                  foregroundColor: Colors.black,
                  elevation: 2.0,
                  backgroundColor: Colors.blue.shade100,
                ),
                onPressed: () {},
                child: const Text('All'),
              ),
              TextButton(
                style: TextButton.styleFrom(
                  minimumSize: const Size(105, 36),
                  padding: const EdgeInsets.symmetric(horizontal: 10),
                  foregroundColor: Colors.black,
                  elevation: 2.0,
                  backgroundColor: Colors.grey.shade400,
                ),
                onPressed: () {},
                child: const Text('Over Spent'),
              ),
              TextButton(
                style: TextButton.styleFrom(
                  minimumSize: const Size(95, 36),
                  padding: const EdgeInsets.symmetric(horizontal: 10),
                  foregroundColor: Colors.black,
                  elevation: 2.0,
                  backgroundColor: Colors.grey.shade400,
                ),
                onPressed: () {},
                child: const Text('On track'),
              )
            ],
          ),
        ),
        Expanded(
          child: Container(
            padding: const EdgeInsets.fromLTRB(15.0, 8, 2, 8),
            child: ListView.builder(
              itemBuilder: (BuildContext context, int index) {
                return Row(
                  children: [
                    Padding(
                      padding: const EdgeInsets.all(3.0),
                      child: Container(
                        padding: const EdgeInsets.all(5.0),
                        width: MediaQuery.of(context).size.width * 0.8,
                        height: 70,
                        decoration: BoxDecoration(
                            borderRadius:
                                const BorderRadius.all(Radius.circular(20)),
                            color: Colors.grey.shade200),
                      ),
                    ),
                    Padding(
                      padding: const EdgeInsets.fromLTRB(5.0, 2, 2, 2),
                      child: Container(
                        padding: const EdgeInsets.all(2.0),
                        width: MediaQuery.of(context).size.width * 0.14,
                        height: 70,
                        child: const IconButton(
                            alignment: Alignment.centerLeft,
                            padding: EdgeInsets.fromLTRB(2, 2, 0, 2),
                            color: Colors.white,
                            onPressed: null,
                            icon: Icon(
                              Icons.edit,
                              color: Colors.white,
                            )),
                      ),
                    )
                  ],
                );
              },
              itemCount: 5,
              scrollDirection: Axis.vertical,
            ),
          ),
        )
      ],
    );
  }
}
