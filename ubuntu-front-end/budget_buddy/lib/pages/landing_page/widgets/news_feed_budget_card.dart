import 'package:budget_buddy/data_providers/newsDataProvider.dart';
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

class NewsFeedBudgetCard extends ConsumerWidget {
  const NewsFeedBudgetCard({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final data = ref.watch(newsDataProvider);

    return Padding(
      padding: const EdgeInsets.only(top: 8.0, bottom: 15.0),
      child: Container(
        decoration: BoxDecoration(
            borderRadius: BorderRadius.circular(8.0),
            color: Colors.indigo[100],
            boxShadow: [
              BoxShadow(
                  blurRadius: 3,
                  color: Colors.black.withOpacity(0.5),
                  offset: const Offset(0, 3)),
            ]),
        child: Column(
          children: [
            Center(
              child: data.when(
                  data: (data) {
                    return Column(
                      children: [Text(data)],
                    );
                  },
                  error: (err, s) => Text(err.toString()),
                  loading: () => const Center(
                        child: CircularProgressIndicator(),
                      )),
            )
          ],
        ),
      ),
    );
  }
}
