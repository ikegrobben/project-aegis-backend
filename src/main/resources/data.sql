/* Add categories */
INSERT INTO category(id, name)
VALUES
(1, 'Fire alarm'),
(2, 'Lost & Found'),
(3, 'Theft'),
(4, 'Unwanted visitor'),
(5, 'Drunk guest'),
(6, 'Safe reset');

/* Add locations */
INSERT INTO location(id, name)
VALUES
    (1, 'Lobby'),
    (2, 'Reception');

INSERT INTO job(id, name)
VALUES
(1, 'Security Manager'),
(2, 'Team Leader'),
(3, 'Security Guard');


/* Add reports */
INSERT INTO report(id, report_date)
VALUES
(1, '2022-03-29'),
(2, '2022-03-30'),
(3, '2022-04-05'),
(4, '2022-04-08');

INSERT INTO users(id, username, firstname, lastname, password, role, enabled, job_id)
VALUES
    (1, 'Ike', 'Ike', 'Grobben', '$2a$12$sxL/FAPcdpOJWhycFug/Zu8ZSqKvus9B0Nvp2lNgocUUj/5xtx7Oq', 'ADMIN', 1, 1),
    (2, 'Sam', 'Sam', 'Barnhoorn', '$2a$12$c6H3DopaQN8HRtGQ8DJU5eVwdtez4HnBUzGJTCHZZiMMsDSVI2kYe', 'ADMIN', 1, 2),
    (3, 'Johan', 'Johan', 'van Oosten', '$2a$12$TDHg0AIXKXQFQjliurOE6uFi742LVjVXttPgDCGEpJFdwnZ9.SfuW', 'ADMIN', 0, 2),
    (4, 'Nova', 'Nova', 'Eeken', '$2a$12$bIXrztIKJ1QE7eT5xohhC.pV5bvVdGdLcFjAFgsqfYslzSPQwkITW', 'USER', 1, 3),
    (5, 'Robertjan', 'Robert-jan', 'Elias', '$2a$12$0jHdoH0KWKlkGFZ6O783YekAzLoRsr5CVv1e1GhRDpAhretnd2rx.', 'USER', 1, 3),
    (6, 'Keanu', 'Keanu', 'Grobben', '$2a$12$Ud1gGeho69G38u6i0NjjReJvzRfL/o24mY1eyhA759sksS51/i2i.', 'ADMIN', 0, 2);

/* Add report items */
/* Need to add locations, Users & Images */

INSERT INTO reportitem(id, status, content, report_item_date_time, category_id, location_id, report_id, users_id)
VALUES
(1, 'Closed', 'Phasellus rhoncus lacus ac sem fringilla, sit amet porttitor lectus tristique. Cras fermentum dignissim condimentum. Phasellus accumsan eros et gravida euismod. Integer in massa ac lacus commodo tincidunt a eu risus. Integer vulputate eros nec eros dictum, id varius dolor mattis. Sed ac congue purus.', '2022-03-29T10:05:33', 2, 1, 1, 1),
(2, 'Closed', 'Sed molestie sem eget malesuada iaculis. Fusce vehicula odio ac eleifend hendrerit. Etiam accumsan eu elit eu convallis. Nulla dolor elit, condimentum non varius nec, cursus ac velit. Etiam dignissim sollicitudin justo. Nullam a mollis erat, vitae blandit felis. Integer sed mauris elementum, commodo odio ut, viverra quam.', '2022-03-30T11:22:33', 1, 2, 2, 1),
(3, 'Open', 'Curabitur nec iaculis turpis. Integer condimentum leo nec sodales sodales. Ut rutrum augue ut nulla rutrum, id congue magna porttitor.', '2022-03-30T10:05:33', 1, 2, 2, 2),
(4, 'Open', 'Quisque porttitor id nulla euismod viverra. Fusce ut vestibulum mauris, ac tristique nisi. Maecenas rhoncus, nisi sed convallis pharetra, lacus turpis suscipit urna, id sodales lectus quam in dui. Suspendisse vitae tortor eleifend, auctor ex vel, pulvinar est.', '2022-04-05T10:05:33', 4, 2, 3, 1),
(5, 'Closed', 'Vivamus ligula leo, interdum ac dolor vel, porttitor suscipit ipsum. Aenean efficitur velit tincidunt, dignissim est at, laoreet elit. Donec accumsan sem magna, id porttitor neque sodales at. Praesent aliquet, ipsum nec fringilla pretium, tortor nulla elementum mi, in rhoncus nisl enim vel libero.', '2022-04-05T13:22:12', 5, 1, 3, 2),
(6, 'Open', 'Sed ac congue purus. Vivamus sagittis fermentum magna vel molestie. Praesent sodales rutrum tortor nec blandit. Sed molestie sem eget malesuada iaculis. Fusce vehicula odio ac eleifend hendrerit. Etiam accumsan eu elit eu convallis. Nulla dolor elit, condimentum non varius nec, cursus ac velit. Etiam dignissim sollicitudin justo.', '2022-04-08T22:15:44', 6, 1, 4,1 );
-- (1, 'Closed', 'Dit is een test', '2022-03-29T10:05:33', 2, 1);
-- (1, 'Closed', 'Dit is een test', '2022-03-29T10:05:33', 2, 1);
-- (1, 'Closed', 'Dit is een test', '2022-03-29T10:05:33', 2, 1);
-- (1, 'Closed', 'Dit is een test', '2022-03-29T10:05:33', 2, 1);
-- (1, 'Closed', 'Dit is een test', '2022-03-29T10:05:33', 2, 1);
-- (1, 'Closed', 'Dit is een test', '2022-03-29T10:05:33', 2, 1);
-- (1, 'Closed', 'Dit is een test', '2022-03-29T10:05:33', 2, 1);

